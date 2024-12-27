package com.cobranza.gestiondeudores_microservices.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cobranza.gestiondeudores_microservices.entidades.Operador;
@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
}
