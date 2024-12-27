package com.cobranza.gestiondeudores_microservices.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String resultado;
    private LocalDate fecha;
    @Column(name = "deuda_id", nullable = false)
    private Long deudaId;
}
