package com.example.sistemaSeguros.controller;

import com.example.sistemaSeguros.entity.Seguro;
import com.example.sistemaSeguros.entity.Vehiculo;
import com.example.sistemaSeguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguros")

public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @PostMapping("/register")
    public ResponseEntity<?> registerSeguro(@RequestBody Seguro seguro) {
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Seguro>> listSeguros() {
        List<Seguro> seguros = seguroService.listSeguro();
        return ResponseEntity.ok(seguros);
    }

    @GetMapping("/vehiculo/{vehiculoId}")
    public ResponseEntity<List<Seguro>> getSegurosByVehiculo(@PathVariable Long vehiculoId) {
        List<Seguro> seguros = seguroService.getSegurosByVehiculo(vehiculoId);
        return ResponseEntity.ok(seguros);
    }

    @PutMapping("/update/{seguroId}")
    public ResponseEntity<?> updateSeguro(@PathVariable Long seguroId, @RequestBody Seguro seguro) {
        try {
            Seguro updateSeguro = new Seguro();

            updateSeguro.setSeguroId(seguro.getSeguroId());

            updateSeguro.setCompaniaSeguro(seguro.getCompaniaSeguro());
            updateSeguro.setPolizaSeguro(seguro.getPolizaSeguro());
            updateSeguro.setFechaInicioSeguro(seguro.getFechaInicioSeguro());
            updateSeguro.setFechaVencimientoSeguro(seguro.getFechaVencimientoSeguro());

            Seguro seguroDB = seguroService.updateSeguro(seguroId, updateSeguro);

            return ResponseEntity.ok(seguroDB);

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }


    @DeleteMapping("/delete/{seguroId}")
    public ResponseEntity<?> deleteSeguro(@PathVariable Long seguroId) {
        try {
            seguroService.deleteSeguro(seguroId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
