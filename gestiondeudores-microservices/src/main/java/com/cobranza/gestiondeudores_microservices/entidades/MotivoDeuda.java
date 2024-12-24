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
public class MotivoDeuda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoMoneda; // Tipo de moneda
    private String tipoDoc;
    private String nroDoc;
    private Double descCompania; // Descuento de la compañía
    private Integer diasMora; // Días de mora
    @Column(name = "deudor_id", nullable = false)
    private Long deudorId; // Campo que almacena el ID del operador
    @Column(name = "fecha_ven", nullable = false)
    private LocalDate fechaVencimiento; // Fecha de vencimiento
}
