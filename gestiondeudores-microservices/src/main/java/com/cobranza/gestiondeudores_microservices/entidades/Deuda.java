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
public class Deuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoMoneda; // Tipo de moneda
    private String prioridad;
    private String origen; // Origen de la deuda
    private String producto; // Producto de la deuda
    private Double montoDeuda; // Monto de la deuda
    private Double descCompania; // Descuento de la compañía
    private String estado; // Descuento del operador
    @Column(name = "deudor_id", nullable = false)
    private Long deudorId; // Campo que almacena el ID del operador
    @Column(name = "fecha_ven", nullable = false)
    private LocalDate fechaVencimiento; // Fecha de vencimiento
    @Column(name = "operador_id", nullable = false)
    private Long operadorId; // Solo contiene el ID del operador
}