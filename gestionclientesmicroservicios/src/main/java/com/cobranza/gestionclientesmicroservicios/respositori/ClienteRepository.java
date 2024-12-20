package com.cobranza.gestionclientesmicroservicios.respositori;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cobranza.gestionclientesmicroservicios.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados (si es necesario) pueden añadirse aquí
    Cliente findByEmail(String email);
}
