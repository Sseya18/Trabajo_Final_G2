package com.cobranza.autenticacion_microservices.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cobranza.autenticacion_microservices.entidades.Autenticacion;
import com.cobranza.autenticacion_microservices.repositori.AutenticacionRepository;

@Service
public class AutenticacionServicio {

    @Autowired
    private AutenticacionRepository autenticacionRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Autenticacion registrarOperador(String usuario, String contrasena, String nombreOperador, String apellidoOperador) {
        Autenticacion operador = new Autenticacion();
        operador.setUsuario(usuario);
        operador.setContrasena(passwordEncoder.encode(contrasena));
        operador.setNombreOperador(nombreOperador);
        operador.setApellidoOperador(apellidoOperador);
        return autenticacionRepositorio.save(operador);
    }

    public Optional<Autenticacion> buscarPorUsuario(String usuario) {
        return autenticacionRepositorio.findByUsuario(usuario);
    }
}

