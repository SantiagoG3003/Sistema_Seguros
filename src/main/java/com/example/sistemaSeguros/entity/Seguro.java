package com.example.sistemaSeguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeguro")
    private Long SeguroId;

    @OneToOne
    @JoinColumn (name = "idVehiculo",referencedColumnName = "idVehiculo")
    private Vehiculo vehiculo;

    @Column(name = "compañia", nullable = false)
    private String companiaSeguro;

    @Column(name = "numeroPoliza", nullable = false)
    private String polizaSeguro;

    @Column(name = "fechaInicio", nullable = false)
    private String fechaInicioSeguro;

    @Column(name = "fechaVencimiento", nullable = false)
    private String fechaVencimientoSeguro;
}
