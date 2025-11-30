package com.example.sistemaSeguros.service.implementacion;

import com.example.sistemaSeguros.entity.Conductor;
import com.example.sistemaSeguros.repository.ConductorRepository;
import com.example.sistemaSeguros.service.ConductorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServicelmpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listConductor() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor updateConductor(Long conductorId, Conductor conductor) {
        Conductor conductorBD = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        conductorBD.setNombreConductor(conductor.getNombreConductor());
        conductorBD.setLicenciaConductor(conductor.getLicenciaConductor());
        conductorBD.setTelefonoConductor(conductor.getTelefonoConductor());
        conductorBD.setDireccionConductor(conductor.getDireccionConductor());
        conductorBD.setDisponibilidad(conductor.getDisponibilidad());

        return conductorRepository.save(conductorBD);
    }

    @Override
    public void deleteConductor(Long conductorId) {
        if (!conductorRepository.existsById(conductorId)) {
            throw new RuntimeException("Conductor no encontrado");
        }
        conductorRepository.deleteById(conductorId);
    }

    @SneakyThrows
    @Override
    public Conductor updateProduct(Long conductorId, Conductor conductor) {
        return updateConductor(conductorId, conductor);
    }
}
