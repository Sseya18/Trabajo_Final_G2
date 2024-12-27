package com.cobranza.gestiondeudores_microservices.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cobranza.gestiondeudores_microservices.entidades.Deuda;
import com.cobranza.gestiondeudores_microservices.repositori.DeudaRepository;



@Service
public class DeudaService {

    @Autowired
    private DeudaRepository deudaRepository;

    public List<Deuda> findAll() {
        return deudaRepository.findAll();
    }

    public Deuda findById(Long id) {
        return deudaRepository.findById(id).orElse(null);
    }

    public Deuda save(Deuda deuda) {
        return deudaRepository.save(deuda);
    }

    public List<Deuda> getAllMotivos() {
        return deudaRepository.findAll();
    }
}