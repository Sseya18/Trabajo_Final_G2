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

    /**
     * Guarda un nuevo deudor en la base de datos.
     * 
     * @param deudor El deudor a guardar.
     * @return El deudor guardado.
     */
    public Deudor saveDeudor(Deudor deudor) {
        return deudorRepository.save(deudor);
    }

    /**
     * Busca un deudor por su ID.
     * 
     * @param id El ID del deudor.
     * @return Un Optional con el deudor si existe.
     */
    public Deudor getDeudorById(Long id) {
        return deudorRepository.findById(id).orElse(null);
    }
    /**
     * Devuelve una lista de todos los deudores.
     * 
     * @return Lista de deudores.
     */
    public List<Deudor> getAllDeudores() {
        return deudorRepository.findAll();
    }

    /**
     * Elimina un deudor por su ID.
     * 
     * @param id El ID del deudor a eliminar.
     */
    public void deleteDeudorById(Long id) {
        deudorRepository.deleteById(id);
    }

    /**
     * Obtiene todos los deudores asociados a un operador.
     * 
     * @param operadorId El ID del operador.
     * @return Lista de deudores asociados al operador.
     */
    public List<Deudor> getDeudoresByOperadorId(Long operadorId) {
        return deudorRepository.findByOperadorId(operadorId);
    }
}
