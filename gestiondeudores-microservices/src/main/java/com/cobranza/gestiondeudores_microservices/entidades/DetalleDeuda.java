package com.cobranza.gestiondeudores_microservices.entidades;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleDeuda {

    private String prioridad; // Prioridad del deudor (TOP, P1, P2, P3)
    private String tipo;//natural juridico del deudor
    private String nombres; // Nombres del deudor
    private String telefono; // Teléfono del deudor
    private String origen;//detalles de la deuda
    private String producto; // Producto relacionado a la deuda
    private Double montoDeuda; // Monto total de la deuda
    private LocalDate fechaVencimiento; // Fecha de vencimiento
    private Long operadorId; // Solo contiene el ID del operador
    private Long deudaId; // Solo contiene el ID de la deuda
    private Long deudorId;
    private LocalDate fechaOperacionUltima;//fecha de la operacion
    private String estado;// resultado de la operación ultima


    public DetalleDeuda(String prioridad, String tipo, String nombres, String telefono, String origen, 
                    String producto, Double montoDeuda, LocalDate fechaVencimiento, 
                    Long operadorId, Long deudaId, Long deudorId, LocalDate fechaOperacionUltima, 
                    String estado) {
    this.prioridad = prioridad;
    this.tipo = tipo;
    this.nombres = nombres;
    this.telefono = telefono;
    this.origen = origen;
    this.producto = producto;
    this.montoDeuda = montoDeuda;
    this.fechaVencimiento = fechaVencimiento;
    this.operadorId = operadorId;
    this.deudaId = deudaId;
    this.deudorId = deudorId;
    this.fechaOperacionUltima = fechaOperacionUltima;
    this.estado=estado;
}

}
