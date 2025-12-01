package com.example.sistemaSeguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seguro")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idseguro")
    private Long seguroId;

    @OneToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "idVehiculo")
    private Vehiculo vehiculo;

    @Column(name = "compania", nullable = false)
    private String companiaSeguro;

    @Column(name = "numero_poliza", nullable = false)
    private String polizaSeguro;

    @Column(name = "fecha_inicio", nullable = false)
    private String fechaInicioSeguro;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimientoSeguro;
}
