package com.cobranza.generacioncompromisopago_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.generacioncompromisopago_microservices.entidades.CompromisoPago;
import com.cobranza.generacioncompromisopago_microservices.repositori.CompromisoPagoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compromisopago")
public class CompromisoPagoController {

    @Autowired
    private CompromisoPagoRepository compromisoPagoRepository;

    // Obtener todos los compromisos
    @GetMapping
    public List<CompromisoPago> obtenerTodos() {
        return compromisoPagoRepository.findAll();
    }

    // Obtener un compromiso pago por ID
    @GetMapping("/{id}")
    public ResponseEntity<CompromisoPago> obtenerPorId(@PathVariable Long id) {
        return compromisoPagoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo compromiso pago
    @PostMapping
    public CompromisoPago crear(@RequestBody CompromisoPago compromisoPago) {
        return compromisoPagoRepository.save(compromisoPago);
    }

    // Actualizar un compromiso pago
    @PutMapping("/{id}")
    public ResponseEntity<CompromisoPago> actualizar(@PathVariable Long id, @RequestBody CompromisoPago detallesCompromisoPago) {
        return compromisoPagoRepository.findById(id)
                .map(compromisoPago -> {
                    compromisoPago.setFechaAcordada(detallesCompromisoPago.getFechaAcordada());
                    compromisoPago.setMontoAcordado(detallesCompromisoPago.getMontoAcordado());
                    compromisoPago.setCorreoElectronico(detallesCompromisoPago.getCorreoElectronico());
                    compromisoPago.setTelefono(detallesCompromisoPago.getTelefono());
                    compromisoPago.setDniDeudor(detallesCompromisoPago.getDniDeudor());
                    compromisoPago.setIdDeudor(detallesCompromisoPago.getIdDeudor());
                    return ResponseEntity.ok(compromisoPagoRepository.save(compromisoPago));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un compromiso pago
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return compromisoPagoRepository.findById(id)
                .map(compromisoPago -> {
                    compromisoPagoRepository.delete(compromisoPago);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
