package com.cobranza.gestiondeudores_microservices.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cobranza.gestiondeudores_microservices.entidades.Operador;
import com.cobranza.gestiondeudores_microservices.repositori.OperadorRepository;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    public Operador saveOperador(Operador operador) {
        return operadorRepository.save(operador);
    }

    public List<Operador> getAllOperadores() {
        return operadorRepository.findAll();
    }

    public Operador getOperadorById(Long id) {
        return operadorRepository.findById(id).orElse(null);
    }

    public void deleteOperador(Long id) {
        operadorRepository.deleteById(id);
    }
}
