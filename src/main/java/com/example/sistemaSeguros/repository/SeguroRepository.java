package com.example.sistemaSeguros.repository;

import com.example.sistemaSeguros.entity.Seguro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    Optional<Seguro> findBySeguroId(Long SeguroId);
    List<Seguro> findByVehiculo_VehiculoId(Long vehiculoId);
}
