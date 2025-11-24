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
    private String vehiculoPlaca;

    @Column(name = "marca", nullable = false)
    private String vehiculoMarca;

    @Column(name = "modelo", nullable = false)
    private String vehiculoModelo;

    @Column(name = "ano", nullable = false)
    private int vehiculoAno;

    @Column(name = "color", nullable = false)
    private String vehiculoColor;
}
