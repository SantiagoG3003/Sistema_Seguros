package com.example.sistemaSeguros.service;

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
}