package com.cobranza.gestiondeudores_microservices.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cobranza.gestiondeudores_microservices.entidades.MotivoDeuda;
import com.cobranza.gestiondeudores_microservices.repositori.MotivoRepository;



@Service
public class MotivoService {

    @Autowired
    private MotivoRepository motivoRepository;

    public List<MotivoDeuda> findAll() {
        return motivoRepository.findAll();
    }

    public MotivoDeuda findById(Long id) {
        return motivoRepository.findById(id).orElse(null);
    }

    public MotivoDeuda save(MotivoDeuda motivo) {
        return motivoRepository.save(motivo);
    }

    public List<MotivoDeuda> getAllMotivos() {
        return motivoRepository.findAll();
    }
}