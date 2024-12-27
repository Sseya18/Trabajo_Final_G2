package com.cobranza.gestiondeudores_microservices.repositori;

import com.cobranza.gestiondeudores_microservices.entidades.Deuda;
import com.cobranza.gestiondeudores_microservices.entidades.Deudor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long> {

    List<Deudor> findByOperadorId(Long operadorId);
    
}
