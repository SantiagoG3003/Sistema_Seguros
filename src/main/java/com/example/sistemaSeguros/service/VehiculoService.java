package com.example.sistemaSeguros.service;

import com.example.sistemaSeguros.entity.Conductor;
import com.example.sistemaSeguros.entity.Vehiculo;
import lombok.SneakyThrows;

import java.util.List;

public interface VehiculoService {

    Vehiculo registerVehiculo(Vehiculo vehiculo);

    List<Vehiculo>listVehiculo();

    Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo);

    void deleteVehiculo(Long vehiculoId);

    @SneakyThrows
    Vehiculo updateProduct(Long vehiculoId, Vehiculo vehiculo);

    interface ConductorService {

        Conductor registerConductor(Conductor conductor);

        List<Conductor> listConductor();

        Conductor updateConductor(Long conductorId, Conductor conductor);

        void deleteConductor(Long conductorId);

        Conductor updateProduct(Long conductorId, Conductor conductor);
    }
}