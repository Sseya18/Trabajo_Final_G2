
package com.cobranza.gestiondeudores_microservices.controller;

import com.cobranza.gestiondeudores_microservices.entidades.Deuda;
import com.cobranza.gestiondeudores_microservices.servicios.DeudaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deudas")
public class DeudaController {
    @Autowired
    private DeudaService deudaService;
    
    @GetMapping
    public List<Deuda> getAllDeudas() {
        return deudaService.findAll();
    }

    @GetMapping("/{id_deuda}")
    public ResponseEntity<Deuda> getDeudaById(@PathVariable Long id_deuda) {
        Deuda deuda=deudaService.findById(id_deuda);
        if (deuda != null) {
            return ResponseEntity.ok(deuda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Deuda createDeuda(@RequestBody Deuda deuda) {
        return deudaService.save(deuda);
    }
}
