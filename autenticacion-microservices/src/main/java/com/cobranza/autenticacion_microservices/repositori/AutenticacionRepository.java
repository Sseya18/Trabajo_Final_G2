package com.cobranza.autenticacion_microservices.repositori;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cobranza.autenticacion_microservices.entidades.Autenticacion;
import java.util.Optional;
public interface AutenticacionRepository extends JpaRepository<Autenticacion, Long> {
    Optional<Autenticacion> findByUsuario(String usuario);
}