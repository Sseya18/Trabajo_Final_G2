package com.cobranza.gestiondeudores_microservices.repositori;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cobranza.gestiondeudores_microservices.entidades.DetalleDeuda;
import com.cobranza.gestiondeudores_microservices.entidades.Deuda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface DetalleDeudaRepository extends JpaRepository<Deuda, Long> {

    @Query("""
    SELECT new com.cobranza.gestiondeudores_microservices.entidades.DetalleDeuda(
        d.prioridad, deudor.tipo, deudor.nombres, deudor.telefono,
        d.origen, d.producto, d.montoDeuda, d.fechaVencimiento, d.operadorId,
        d.id, deudor.id, MAX(op.fecha), d.estado
    )
    FROM Deuda d
    JOIN Deudor deudor ON d.deudorId = deudor.id
    LEFT JOIN Operacion op ON op.deudaId = d.id
    WHERE d.operadorId = :operadorId
    GROUP BY d.prioridad, deudor.tipo, deudor.nombres, deudor.telefono,
             d.origen, d.producto, d.montoDeuda, d.fechaVencimiento,
             d.operadorId, d.id, deudor.id
""")
Page<DetalleDeuda> findDetalleDeudaByOperadorId(@Param("operadorId") Long operadorId, Pageable pageable);
}