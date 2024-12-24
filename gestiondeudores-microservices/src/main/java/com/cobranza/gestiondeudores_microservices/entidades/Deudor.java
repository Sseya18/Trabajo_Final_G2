package com.cobranza.gestiondeudores_microservices.entidades;

import java.time.LocalDate;
import jakarta.persistence.Column;
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
    private String prioridad; // Prioridad del deudor (TOP, P1, P2, P3)
    private String tipo;
    private String nombres; // Nombres del deudor
    private String telefono; // Teléfono del deudor
    private String origen;
    private String producto; // Producto relacionado con el deudor
    private Double montoDeuda; // Monto total de la deuda
    @Column(name = "FContacto", nullable = false)
    private LocalDate fechaContacto; // Fecha de vencimiento
    @Column(name = "operador_id", nullable = false)
    private Long operadorId; // Solo contiene el ID del operador
    private String detalle;
}