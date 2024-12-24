
package com.cobranza.gestiondeudores_microservices.controller;

import com.cobranza.gestiondeudores_microservices.entidades.MotivoDeuda;
import com.cobranza.gestiondeudores_microservices.servicios.MotivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/motivos")
public class MotivoController {

    @Autowired
    private MotivoService motivoService;

    @GetMapping
    public List<MotivoDeuda> getAllMotivos() {
        return motivoService.getAllMotivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotivoDeuda> getMotivoById(@PathVariable Long id) {
        MotivoDeuda motivo = motivoService.findById(id);
        if (motivo != null) {
            return ResponseEntity.ok(motivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MotivoDeuda createMotivo(@RequestBody MotivoDeuda motivo) {
        return motivoService.save(motivo);
    }
}
