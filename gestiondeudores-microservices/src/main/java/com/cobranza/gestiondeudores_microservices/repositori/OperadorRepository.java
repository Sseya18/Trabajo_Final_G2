package com.cobranza.gestiondeudores_microservices.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cobranza.gestiondeudores_microservices.entidades.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
}
