package com.cobranza.gestiondeudores_microservices.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "deudores")
public class Deudor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    @Column(name = "monto_deuda", nullable = false)
    private Double montoDeuda;

    @Column(name = "fecha_registro", nullable = false)
    private String fechaRegistro;
}