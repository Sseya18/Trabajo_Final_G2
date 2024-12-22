package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;
import com.cobranza.gestiondeudores_microservices.repositori.DeudorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deudores")
public class DeudorController {

    @Autowired
    private DeudorRepository deudorRepository;

    // Obtener todos los deudores
    @GetMapping
    public List<Deudor> obtenerTodos() {
        return deudorRepository.findAll();
    }

    // Obtener un deudor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Deudor> obtenerPorId(@PathVariable Long id) {
        return deudorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo deudor
    @PostMapping
    public Deudor crear(@RequestBody Deudor deudor) {
        return deudorRepository.save(deudor);
    }

    // Actualizar un deudor
    @PutMapping("/{id}")
    public ResponseEntity<Deudor> actualizar(@PathVariable Long id, @RequestBody Deudor detallesDeudor) {
        return deudorRepository.findById(id)
                .map(deudor -> {
                    deudor.setNombre(detallesDeudor.getNombre());
                    deudor.setApellido(detallesDeudor.getApellido());
                    deudor.setTelefono(detallesDeudor.getTelefono());
                    deudor.setCorreoElectronico(detallesDeudor.getCorreoElectronico());
                    deudor.setMontoDeuda(detallesDeudor.getMontoDeuda());
                    deudor.setFechaRegistro(detallesDeudor.getFechaRegistro());
                    return ResponseEntity.ok(deudorRepository.save(deudor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un deudor
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return deudorRepository.findById(id)
                .map(deudor -> {
                    deudorRepository.delete(deudor);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
