package com.cobranza.gestiondeudores_microservices.entidades;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OperacionRequest {
    private String descripcion;
    private LocalDateTime fechaOperacion;
    private Long DeudorId;
    
}
