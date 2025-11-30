package com.example.sistemaSeguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConductor")
    private Long ConductorId;

    @Column(name = "nombre", nullable = false)
    private String nombreConductor;

    @Column(name = "licencia", nullable = false)
    private String licenciaConductor;

    @Column(name = "telefono", nullable = false)
    private String telefonoConductor;

    @Column(name = "direccion", nullable = false)
    private String direccionConductor;

    @Column(name = "Activo", nullable = false)
    private String disponibilidad;
}
