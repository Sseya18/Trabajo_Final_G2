package com.cobranza.gestiondeudores_microservices.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobranza.gestiondeudores_microservices.entidades.Deuda;
import com.cobranza.gestiondeudores_microservices.entidades.Operacion;
import com.cobranza.gestiondeudores_microservices.repositori.OperacionRepository;

@Service
public class OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;

    @Autowired
    private DeudaService deudaService;

    public Operacion saveOperacion(Long deudaId, Operacion operacion) {
        Deuda deuda = deudaService.findById(deudaId);
        if (deuda == null) {
            throw new IllegalArgumentException("Deuda no encontrado");
        }
        operacion.setDeudaId(deudaId);
        operacion.setFecha(LocalDate.now());
        return operacionRepository.save(operacion);
    }

    public List<Operacion> getOperacionesByDeudaId(Long deudaId) {
        return operacionRepository.findAllByDeudaId(deudaId);
    }
}

