package com.example.sistemaSeguros.service.implementacion;

import com.example.sistemaSeguros.entity.Vehiculo;
import com.example.sistemaSeguros.repository.VehiculoRepository;
import com.example.sistemaSeguros.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listVehiculo() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo) {
        Vehiculo vehiculoBD = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        vehiculoBD.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
        vehiculoBD.setVehiculoMarca(vehiculo.getVehiculoMarca());
        vehiculoBD.setVehiculoModelo(vehiculo.getVehiculoModelo());
        vehiculoBD.setVehiculoColor(vehiculo.getVehiculoColor());

        return vehiculoRepository.save(vehiculoBD);
    }

    @Override
    public void deleteVehiculo(Long vehiculoId) {
        if (!vehiculoRepository.existsById(vehiculoId)) {
            throw new RuntimeException("Vehiculo no encontrado");
        }
        vehiculoRepository.deleteById(vehiculoId);
    }

    @SneakyThrows
    @Override
    public Vehiculo updateProduct(Long vehiculoId, Vehiculo vehiculo) {
        return updateVehiculo(vehiculoId, vehiculo);
    }
}

