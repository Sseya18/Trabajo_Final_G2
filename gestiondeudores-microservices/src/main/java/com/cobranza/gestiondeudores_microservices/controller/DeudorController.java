package com.cobranza.gestiondeudores_microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;

import com.cobranza.gestiondeudores_microservices.entidades.DeudorRequest;
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
    public List<Deudor> obtenerTodos() {
        return deudorService.getAllDeudores();
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
    public ResponseEntity<Deudor> crearDeudor(@RequestBody DeudorRequest deudorRequest) {
        Operador operador = operadorService.getOperadorById(deudorRequest.getOperadorId());
        if (operador == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Deudor nuevoDeudor = new Deudor();
        nuevoDeudor.setNombre(deudorRequest.getNombre());
        nuevoDeudor.setApellido(deudorRequest.getApellido());
        nuevoDeudor.setTelefono(deudorRequest.getTelefono());
        nuevoDeudor.setCorreoElectronico(deudorRequest.getCorreoElectronico());
        nuevoDeudor.setMontoDeuda(deudorRequest.getMontoDeuda());
        nuevoDeudor.setOperador(operador);

        Deudor deudorGuardado = deudorService.saveDeudor(nuevoDeudor);
        return ResponseEntity.ok(deudorGuardado);
    }

}
