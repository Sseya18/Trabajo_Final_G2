package com.cobranza.gestiondeudores_microservices.servicios;

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
        if (deudor == null) {
            throw new IllegalArgumentException("Deudor no encontrado");
        }
        operacion.setDeudor(deudor);
        return operacionRepository.save(operacion);
    }

    public List<Operacion> getOperacionesByDeudorId(Long deudorId) {
        return operacionRepository.findAllByDeudorId(deudorId);
    }
}

