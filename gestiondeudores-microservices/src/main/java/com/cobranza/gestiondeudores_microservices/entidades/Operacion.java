package com.cobranza.gestiondeudores_microservices.entidades;

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

    @Column(name = "deudor_id", nullable = false)
    private Long deudorId; // Campo que almacena el ID del operador

}
