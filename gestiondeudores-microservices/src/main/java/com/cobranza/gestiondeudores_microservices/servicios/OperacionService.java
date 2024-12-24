package com.cobranza.gestiondeudores_microservices.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;
import com.cobranza.gestiondeudores_microservices.entidades.Operacion;
import com.cobranza.gestiondeudores_microservices.repositori.OperacionRepository;

@Service
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    @Autowired
    private DeudorService deudorService;

    public Operacion saveOperacion(Long deudorId, Operacion operacion) {
        // Asignar deudor a la operación
        Deudor deudor = deudorService.getDeudorById(deudorId);
        LocalDate fechaContacto = LocalDate.now();
        if (deudor == null) {
            throw new IllegalArgumentException("Deudor no encontrado");
        }
        deudor.setFechaContacto(fechaContacto);
        deudor.setDetalle(operacion.getResultado());
        operacion.setDeudorId(deudorId);
        return operacionRepository.save(operacion);
    }

    public List<Operacion> getOperacionesByDeudorId(Long deudorId) {
        return operacionRepository.findAllByDeudorId(deudorId);
    }
}

