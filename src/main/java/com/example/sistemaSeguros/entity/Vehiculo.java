package com.example.sistemaSeguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long vehiculoId;

    @Column(name = "placa", nullable = false)
    private String vehiculo_Placa;

    @Column(name = "marca", nullable = false)
    private String vehiculo_Marca;

    @Column(name = "modelo", nullable = false)
    private String vehiculo_Modelo;

    @Column(name = "ano", nullable = false)
    private int vehiculo_Ano;

    @Column(name = "color", nullable = false)
    private String vehiculo_Color;
}
