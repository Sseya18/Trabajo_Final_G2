package com.cobranza.gestiondeudores_microservices.repositori;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;

public interface DeudorRepository extends JpaRepository<Deudor, Long> {
}