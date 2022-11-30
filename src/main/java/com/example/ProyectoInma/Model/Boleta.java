package com.example.ProyectoInma.Model;


import lombok.Data;

import javax.persistence.*;

import java.util.Date;



@Data
@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date fecha = new Date(System.currentTimeMillis());
    private int valorTotal;



}
