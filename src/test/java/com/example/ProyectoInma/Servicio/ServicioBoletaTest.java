package com.example.ProyectoInma.Servicio;


import com.example.ProyectoInma.Model.ProductoBoleta;
import com.example.ProyectoInma.Repository.RepositorioProductoBoleta;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.class)
public class ServicioBoletaTest {
    List<ProductoBoleta> boletas;

    @Autowired
    private RepositorioProductoBoleta repositorioBoleta;


    @ParameterizedTest
    @CsvSource({"CocaCola,1500", "Pepsi,1300", "Producto3,3000", "Producto4,4000"})
    @Rollback(false)
    @DisplayName("Test para guardar un producto en la boleta")
    public void testGuardarProdBol(String nombre, int precio) {
        ProductoBoleta productoBol = new ProductoBoleta( 10, nombre, precio);
        ProductoBoleta productoGuardadoBol = repositorioBoleta.save(productoBol);
        boletas.add(productoBol);

        assertNotNull(productoGuardadoBol);
    }
    @Test
    @DisplayName("Test para calcular el total")
    public void testCalcularTotal(){
        int total=0;

        for (ProductoBoleta boleta : boletas)

                   total=+boleta.getTotal();
        assertThat(total).isEqualTo(98000);

    }
    
    @Test
    @DisplayName("Test para listar en pantalla los productos de la boleta")
    public void testListarProdBol() {
        List<ProductoBoleta> productosBol = (List<ProductoBoleta>) repositorioBoleta.findAll();
        assertThat(productosBol.size()).isGreaterThan(0);


    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @Rollback(false)
    @DisplayName("Test para eliminar producto de boleta por su id")
    public void testEliminarProdBol(int ids) {
        int id = ids;
        boolean ExisteAntesDeEliminar = repositorioBoleta.findById(id).isPresent();

        repositorioBoleta.deleteById(id);

        boolean noExisteDespuesDeEliminar = repositorioBoleta.findById(id).isPresent();

        assertTrue(ExisteAntesDeEliminar);
        assertFalse(noExisteDespuesDeEliminar);


    }

    @Test
    @DisplayName("Test para saber si la boleta se encuentra vacia")
    public void testMostrarBoletaVacia() {
        List<ProductoBoleta> productosBol = (List<ProductoBoleta>) repositorioBoleta.findAll();
        assertThat(productosBol.size()).isEqualTo(0);
    }
}