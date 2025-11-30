package com.example.sistemaSeguros.repository;

import com.example.sistemaSeguros.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConductorRepository extends JpaRepository <Conductor, Long> {
    Optional<Conductor> findByConductorId(Long ConductorId);

}
