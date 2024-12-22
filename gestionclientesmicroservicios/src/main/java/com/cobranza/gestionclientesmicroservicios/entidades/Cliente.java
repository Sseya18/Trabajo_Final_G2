package com.cobranza.gestionclientesmicroservicios.entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefono;

    private String direccion;

    private LocalDate fechaRegistro;

    private String estado; // "ACTIVO" o "INACTIVO"
}
