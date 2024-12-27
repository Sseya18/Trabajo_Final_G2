package com.cobranza.gestiondeudores_microservices.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobranza.gestiondeudores_microservices.entidades.Deudor;
import com.cobranza.gestiondeudores_microservices.repositori.DeudorRepository;

import java.util.List;

@Service
public class DeudorService {

    @Autowired
    private DeudorRepository deudorRepository;

    public Deudor saveDeudor(Deudor deudor) {
        return deudorRepository.save(deudor);
    }
    public Deudor getDeudorById(Long id) {
        return deudorRepository.findById(id).orElse(null);
    }
    public List<Deudor> getAllDeudores() {
        return deudorRepository.findAll();
    }
    public void deleteDeudorById(Long id) {
        deudorRepository.deleteById(id);
    }
}
