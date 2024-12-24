package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cobranza.gestiondeudores_microservices.entidades.Deudor;
import com.cobranza.gestiondeudores_microservices.entidades.Operador;
import com.cobranza.gestiondeudores_microservices.servicios.DeudorService;
import com.cobranza.gestiondeudores_microservices.servicios.OperadorService;

import java.util.List;

@RestController

@RequestMapping("/gestion/deudas/deudores")
public class DeudorController {

    @Autowired
    private DeudorService deudorService;
    
    @Autowired
    private OperadorService operadorService;

    // Obtener todos los deudores
    @GetMapping
    public ResponseEntity<List<Deudor>> obtenerTodos() {
        List<Deudor> deudores = deudorService.getAllDeudores();
        return ResponseEntity.ok(deudores);
    }

    // Obtener un deudor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Deudor> obtenerPorId(@PathVariable Long id) {
        Deudor deudor = deudorService.getDeudorById(id);
        if (deudor != null) {
            return ResponseEntity.ok(deudor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo deudor
    @PostMapping
    public ResponseEntity<?> crearDeudor(@RequestBody Deudor deudor) {
        // Verificar si el operador existe
        Operador operador = operadorService.getOperadorById(deudor.getOperadorId());
        if (operador == null) {
            return ResponseEntity.badRequest().body("El operador especificado no existe.");
        }

        // Guardar el deudor
        try {
            Deudor deudorGuardado = deudorService.saveDeudor(deudor);
            return ResponseEntity.ok(deudorGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error al guardar el deudor: " + e.getMessage());
        }
    }

}
