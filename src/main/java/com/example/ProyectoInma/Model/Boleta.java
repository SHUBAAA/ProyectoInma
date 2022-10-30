package com.example.ProyectoInma.Model;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class Boleta {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "total", nullable = false)
    private Long total;

    @Column(name = "fecha_emision",nullable = false)
    private Date fechaEmision;

    public Boleta() {
    }


}
