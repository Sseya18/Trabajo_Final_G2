package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cobranza.gestiondeudores_microservices.entidades.DetalleDeuda;
import com.cobranza.gestiondeudores_microservices.servicios.DetalleDeudaService;
import org.springframework.data.domain.Page;


@RestController
@RequestMapping("/api/v1/deudas")
public class DetalleDeudaController {

    private final DetalleDeudaService detalleDeudaService;

    public DetalleDeudaController(DetalleDeudaService detalleDeudaService) {
        this.detalleDeudaService = detalleDeudaService;
    }

    @GetMapping("/detalles")
    public ResponseEntity<Page<DetalleDeuda>> getDetalleDeudas(
            @RequestParam Long operadorId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<DetalleDeuda> detalles = detalleDeudaService.getDetalleDeudas(operadorId, page, size);
        return ResponseEntity.ok(detalles);
    }
}