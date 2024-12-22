package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestiondeudores_microservices.entidades.Operacion;
import com.cobranza.gestiondeudores_microservices.servicios.OperacionService;

import java.util.List;

@RestController
@RequestMapping("/gestion/deudas/operaciones")
public class OperacionController {

    @Autowired
    private OperacionService operacionService;

    // Registrar una operación para un deudor
    @PostMapping("/{deudorId}")
    public ResponseEntity<Operacion> registrarOperacion(
            @PathVariable Long deudorId, @RequestBody Operacion operacion) {
        try {
            Operacion operacionGuardada = operacionService.saveOperacion(deudorId, operacion);
            return ResponseEntity.ok(operacionGuardada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Obtener operaciones de un deudor
    @GetMapping("/{deudorId}")
    public ResponseEntity<List<Operacion>> obtenerOperacionesDeDeudor(@PathVariable Long deudorId) {
        List<Operacion> operaciones = operacionService.getOperacionesByDeudorId(deudorId);
        if (operaciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(operaciones);
    }
}
