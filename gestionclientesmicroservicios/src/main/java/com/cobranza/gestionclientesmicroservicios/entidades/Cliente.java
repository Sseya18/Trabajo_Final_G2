package com.cobranza.gestionclientesmicroservicios.entidades;


import jakarta.persistence.*;
import lombok.Data;

// import java.time.LocalDate;

@Entity
@Data
public class Cliente {
    @Id
    private String ruc;

    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(unique = true)
    private String telefono;
    @Column(unique = true, nullable = false)
    private String direccion;
    private String fechaRegistro;

    private String nroDeudoresAsignados;
    private String montoTotalDeuda;
    private String montoSaldado;
}
