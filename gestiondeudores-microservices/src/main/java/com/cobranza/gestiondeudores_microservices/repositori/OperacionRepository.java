package com.cobranza.gestiondeudores_microservices.repositori;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cobranza.gestiondeudores_microservices.entidades.Operacion;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Long> {
    List<Operacion> findAllByDeudorId(Long deudorId);
}
