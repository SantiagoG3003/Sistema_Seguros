package com.example.sistemaSeguros.service.implementacion;

import com.example.sistemaSeguros.entity.Seguro;
import com.example.sistemaSeguros.entity.Vehiculo;
import com.example.sistemaSeguros.repository.SeguroRepository;
import com.example.sistemaSeguros.repository.VehiculoRepository;
import com.example.sistemaSeguros.service.SeguroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Seguro> getSegurosByVehiculo(Long vehiculoId) {
        return seguroRepository.findByVehiculo_VehiculoId(vehiculoId);
    }

    @Override
    public Seguro registerSeguro(Seguro seguro) {

        if (seguro.getVehiculo() == null || seguro.getVehiculo().getVehiculoId() == null) {
            throw new RuntimeException("Debe enviar un vehículo válido para asignar el seguro.");
        }

        Vehiculo vehiculo = vehiculoRepository.findById(seguro.getVehiculo().getVehiculoId())
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        seguro.setVehiculo(vehiculo);

        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listSeguro() {
        return seguroRepository.findAll();
    }

    @Override
    public Seguro updateSeguro(Long seguroId, Seguro seguro) {
        Seguro seguroBD = seguroRepository.findById(seguroId)
                .orElseThrow(() -> new RuntimeException("Seguro no encontrado"));

        seguroBD.setCompaniaSeguro(seguro.getCompaniaSeguro());
        seguroBD.setPolizaSeguro(seguro.getPolizaSeguro());
        seguroBD.setFechaInicioSeguro(seguro.getFechaInicioSeguro());
        seguroBD.setFechaVencimientoSeguro(seguro.getFechaVencimientoSeguro());

        if (seguro.getVehiculo() != null && seguro.getVehiculo().getVehiculoId() != null) {
            Vehiculo vehiculo = vehiculoRepository.findById(seguro.getVehiculo().getVehiculoId())
                    .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
            seguroBD.setVehiculo(vehiculo);
        }

        return seguroRepository.save(seguroBD);
    }

    @Override
    public void deleteSeguro(Long seguroId) {
        if (!seguroRepository.existsById(seguroId)) {
            throw new RuntimeException("Seguro no encontrado");
        }
        seguroRepository.deleteById(seguroId);
    }

    @SneakyThrows
    @Override
    public Seguro updateProduct(Long seguroId, Seguro seguro) {
        return updateSeguro(seguroId, seguro);
    }
}
