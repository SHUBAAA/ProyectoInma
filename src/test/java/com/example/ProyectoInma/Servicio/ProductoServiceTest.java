package com.example.ProyectoInma.Servicio;

import com.example.ProyectoInma.Model.Producto;
import com.example.ProyectoInma.Repository.RepoProducto;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.class)
class ProductoServiceTest {
    @Autowired
    private RepoProducto productoRepositorio;


    @ParameterizedTest
    @CsvSource({"CocaCola,1500,Bebida", "Pepsi,1300,Bebida", "Producto3,3000,Cat3", "Producto4,4000,Cat4"})
    @Rollback(false)
    @Order(2)
    @DisplayName("Test para guardar un producto")
    public void testGuardarProd(String nombre, int precio, String cat) {
        Producto producto = new Producto(nombre, precio, 90, cat);

        Producto productoGuardado = productoRepositorio.save(producto);

        assertNotNull(productoGuardado);
    }
    @Test
    @Order(1)
    @DisplayName("Test para listar en pantalla los productos")
    public void testListarProd() {

        productoRepositorio.save(new Producto("Prueba", 2, 90, "cat"));
        List<Producto> productos = productoRepositorio.findAll();
        assertThat(productos.size()).isGreaterThan(0);


    }
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @Rollback(false)
    @Order(3)
    @DisplayName("Test para editar un producto")
    public void testModProdu(int ids) {
        String nombreMod = "NombreAlterado";
        int precioMod = 9999;
        String catMod = "CatAlterada";
        int id = ids;
        Producto producto = new Producto(nombreMod, precioMod, 800, catMod);
        producto.setId(id);

        productoRepositorio.save(producto);
        Optional<Producto> prodMod = productoRepositorio.findById(id);
        assertThat(prodMod.get().getPrecio()).isEqualTo(precioMod);
        assertThat(prodMod.get().getId()).isEqualTo(id);
        assertThat(prodMod.get().getNombre()).isEqualTo(nombreMod);
        assertThat(prodMod.get().getCategoria()).isEqualTo(catMod);


    }
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @Rollback(false)
    @Order(4)
    @DisplayName("Test para eliminar producto por su id")
    public void testEliminarProd(int ids) {
        int id = ids;
        boolean ExisteAntesDeEliminar = productoRepositorio.findById(id).isPresent();

        productoRepositorio.deleteById(id);

        boolean noExisteDespuesDeEliminar = productoRepositorio.findById(id).isPresent();

        assertTrue(ExisteAntesDeEliminar);
        assertFalse(noExisteDespuesDeEliminar);


    }
    @Test
    @Order(5)
    @DisplayName("Test para saber si la lista de productos se encuentra vacia")
    public void testMostrarlistaVacia() {
        List<Producto> productos =  productoRepositorio.findAll();
        assertThat(productos.size()).isEqualTo(0);
    }

}