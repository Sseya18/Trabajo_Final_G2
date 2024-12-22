package com.cobranza.generacioncompromisopago_microservices.repositori;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cobranza.generacioncompromisopago_microservices.entidades.CompromisoPago;

public interface CompromisoPagoRepository extends JpaRepository<CompromisoPago, Long> {
}