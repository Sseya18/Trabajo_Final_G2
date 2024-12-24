package com.cobranza.autenticacion_microservices.entidades;

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
@Table(name = "autenticacionOperador")
public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario", unique = true)
    private String usuario;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "nombre_operador", nullable = false)
    private String nombreOperador;

    @Column(name = "apellido_operador", nullable = false)
    private String apellidoOperador;

}