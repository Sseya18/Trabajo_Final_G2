package com.cobranza.gestiondeudores_microservices.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Deudor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String tipoDoc;
    private String numDoc; // Número de documento del deudor
    private String nombres; // Nombres del deudor
    private String telefono; // Teléfono del deudor
}