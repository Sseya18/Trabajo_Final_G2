package com.cobranza.gestiondeudores_microservices.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeudorRequest {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;
    private Double montoDeuda;
    private Long operadorId;
}
