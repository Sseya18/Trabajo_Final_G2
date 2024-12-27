package com.cobranza.gestiondeudores_microservices.servicios;

import org.springframework.stereotype.Service;

import com.cobranza.gestiondeudores_microservices.repositori.DetalleDeudaRepository;
import com.cobranza.gestiondeudores_microservices.entidades.DetalleDeuda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
@Service
public class DetalleDeudaService {

    private final DetalleDeudaRepository detalleDeudaRepository;

    public DetalleDeudaService(DetalleDeudaRepository detalleDeudaRepository) {
        this.detalleDeudaRepository = detalleDeudaRepository;
    }

    public Page<DetalleDeuda> getDetalleDeudas(Long operadorId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return detalleDeudaRepository.findDetalleDeudaByOperadorId(operadorId, pageable);
    }
}