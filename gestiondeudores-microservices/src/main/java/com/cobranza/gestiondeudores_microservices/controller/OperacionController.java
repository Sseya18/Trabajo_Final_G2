package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestiondeudores_microservices.entidades.Operacion;
import com.cobranza.gestiondeudores_microservices.servicios.OperacionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deudas/operaciones")
public class OperacionController {

    @Autowired
    private OperacionService operacionService;

    // Registrar una operación para un deudor
    @PostMapping("/{deudaId}")
    public ResponseEntity<Operacion> registrarOperacion(
            @PathVariable Long deudaId, @RequestBody Operacion operacion) {
        try {
            Operacion operacionGuardada = operacionService.saveOperacion(deudaId, operacion);
            return ResponseEntity.ok(operacionGuardada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener operaciones de un deudor
    @GetMapping("/{deudaId}")
    public ResponseEntity<List<Operacion>> obtenerOperacionesDeDeudor(@PathVariable Long deudaId) {
        List<Operacion> operaciones = operacionService.getOperacionesByDeudaId(deudaId);
        if (operaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operaciones);
    }
}
