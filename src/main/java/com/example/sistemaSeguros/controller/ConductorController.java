package com.example.sistemaSeguros.controller;

import com.example.sistemaSeguros.entity.Conductor;
import com.example.sistemaSeguros.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerConductor(@RequestBody Conductor conductor) {
        Conductor newConductor = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConductor);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Conductor>> listConductores() {
        List<Conductor> conductores = conductorService.listConductor();
        return ResponseEntity.ok(conductores);
    }

    @PutMapping("/update/{conductorId}")
    public ResponseEntity<?> updateConductor(@PathVariable Long conductorId, @RequestBody Conductor conductor) {
        try {
            Conductor updateConductor = new Conductor();
            updateConductor.setNombreConductor(conductor.getNombreConductor());
            updateConductor.setLicenciaConductor(conductor.getLicenciaConductor());
            updateConductor.setTelefonoConductor(conductor.getTelefonoConductor());
            updateConductor.setDireccionConductor(conductor.getDireccionConductor());
            updateConductor.setDisponibilidad(conductor.getDisponibilidad());


            Conductor conductorDB = conductorService.updateConductor(conductorId, updateConductor);
            return ResponseEntity.ok(conductorDB);

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{conductorId}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long conductorId) {
        try {
            conductorService.deleteConductor(conductorId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}