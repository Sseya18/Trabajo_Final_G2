package com.cobranza.autenticacion_microservices.controller;

import com.cobranza.autenticacion_microservices.entidades.Autenticacion;
import com.cobranza.autenticacion_microservices.servicios.AutenticacionServicio;
import com.cobranza.autenticacion_microservices.servicios.JwtService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacionControlador {

    @Autowired
    private AutenticacionServicio autenticacionServicio;

    @Autowired
    private JwtService jwtService;

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

            // Genera el token JWT
            String token = jwtService.generateToken(autenticacion.getUsuario());
            
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
    }
    @GetMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Extrae el token del encabezado Authorization (formato: Bearer <token>)
            if (!authorizationHeader.startsWith("Bearer ")) {
                return ResponseEntity.badRequest().body("Token no válido");
            }

            String token = authorizationHeader.substring(7); // Elimina "Bearer "

            // Valida el token y extrae la información
            String username = jwtService.extractUsername(token);
            Autenticacion operador = autenticacionServicio.buscarPorUsuario(username).orElseThrow();
            return ResponseEntity.ok(Map.of(
                "message", "Token válido",
                "usuario", operador.getId(),
                "nombre", operador.getNombreOperador(),
                "apellido", operador.getApellidoOperador()
            ));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Token no válido o expirado");
        }
    }
}
