package com.cobranza.gestiondeudores_microservices.repositori;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;

@Repository
public interface DeudorRepository extends JpaRepository<Deudor, Long> {

    List<Deudor> findByOperadorId(Long operadorId);
}