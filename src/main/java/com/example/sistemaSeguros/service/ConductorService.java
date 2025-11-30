package com.example.sistemaSeguros.service;

import com.example.sistemaSeguros.entity.Conductor;

import java.util.List;

public interface ConductorService {
    Conductor registerConductor(Conductor conductor);

    List<Conductor> listConductor();

    Conductor updateConductor(Long conductorId, Conductor conductor);

    void deleteConductor(Long conductorId);

    Conductor updateProduct(Long conductorId, Conductor conductor);
}
