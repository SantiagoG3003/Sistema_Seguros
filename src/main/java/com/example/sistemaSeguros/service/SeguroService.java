package com.example.sistemaSeguros.service;

import com.example.sistemaSeguros.entity.Seguro;

import java.util.List;

public interface SeguroService {

    Seguro registerSeguro(Seguro seguro);


    List<Seguro> getSegurosByVehiculo(Long vehiculoId);

    List<Seguro> listSeguro();

    Seguro updateSeguro(Long seguroId, Seguro seguro);

    void deleteSeguro(Long seguroId);

    Seguro updateProduct(Long seguroId, Seguro seguro);


}
