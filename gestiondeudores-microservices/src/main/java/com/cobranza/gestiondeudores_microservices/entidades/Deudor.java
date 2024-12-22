package com.cobranza.gestiondeudores_microservices.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Deudor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    private String telefono;
    private String correoElectronico;
    private Double montoDeuda;
    private LocalDateTime fechaRegistro;


    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Operador operador;

    // Getters y setters
}