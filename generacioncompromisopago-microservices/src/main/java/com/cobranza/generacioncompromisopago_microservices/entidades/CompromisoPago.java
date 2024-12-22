package com.cobranza.generacioncompromisopago_microservices.entidades;

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
@Table(name = "compromisoPago")
public class CompromisoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_Acordada", nullable = false)
    private String fechaAcordada;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;

    @Column(name = "monto_acordado", nullable = false)
    private Double montoAcordado;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "Id_cliente", nullable = false)
    private Integer idDeudor;

    @Column(name = "dniDeudor", nullable = false)
    private Integer dniDeudor;
}