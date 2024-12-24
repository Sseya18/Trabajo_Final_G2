package com.cobranza.gestiondeudores_microservices.repositori;

import com.cobranza.gestiondeudores_microservices.entidades.MotivoDeuda;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoRepository extends JpaRepository<MotivoDeuda, Long> {
    
}
