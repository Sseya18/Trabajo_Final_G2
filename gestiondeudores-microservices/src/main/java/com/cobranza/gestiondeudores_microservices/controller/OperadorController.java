package com.cobranza.gestiondeudores_microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestiondeudores_microservices.entidades.Operador;
import com.cobranza.gestiondeudores_microservices.servicios.OperadorService;

@RestController
@RequestMapping("/gestion/deudas/operadores")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping
    public ResponseEntity<Operador> registrarOperador(@RequestBody Operador operador) {
        Operador nuevoOperador = operadorService.saveOperador(operador);
        return ResponseEntity.ok(nuevoOperador);
    }

    @GetMapping
    public ResponseEntity<List<Operador>> listarOperadores() {
        List<Operador> operadores = operadorService.getAllOperadores();
        return ResponseEntity.ok(operadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operador> obtenerOperador(@PathVariable Long id) {
        Operador operador = operadorService.getOperadorById(id);
        if (operador != null) {
            return ResponseEntity.ok(operador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOperador(@PathVariable Long id) {
        operadorService.deleteOperador(id);
        return ResponseEntity.noContent().build();
    }
}
