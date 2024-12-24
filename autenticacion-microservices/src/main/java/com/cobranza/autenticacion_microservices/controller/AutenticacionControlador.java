package com.cobranza.autenticacion_microservices.controller;

import com.cobranza.autenticacion_microservices.entidades.Autenticacion;
import com.cobranza.autenticacion_microservices.servicios.AutenticacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacionControlador {

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarOperador(@RequestBody Autenticacion autenticacion) {
        Autenticacion registrado = autenticacionServicio.registrarOperador(
            autenticacion.getUsuario(),
            autenticacion.getContrasena(),
            autenticacion.getNombreOperador(),
            autenticacion.getApellidoOperador()
        );
        return ResponseEntity.ok(registrado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Autenticacion autenticacion) {
        var operador = autenticacionServicio.buscarPorUsuario(autenticacion.getUsuario());
        if (operador.isPresent() && 
            new BCryptPasswordEncoder().matches(autenticacion.getContrasena(), operador.get().getContrasena())) {
            return ResponseEntity.ok("Login exitoso");
        }
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }
}
