package com.co.programacion.ejemplosprintboot1.services;

import com.co.programacion.ejemplosprintboot1.entities.Mesa;
import com.co.programacion.ejemplosprintboot1.repositories.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    // Crear mesa
    public Mesa registrar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    // Listar mesas
    public List<Mesa> listar() {
        return mesaRepository.findAll();
    }

    // Buscar mesa por ID
    public Mesa buscarPorId(Long id) {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id " + id));
    }

    // Actualizar mesa
    public Mesa actualizar(Long id, Mesa mesa) {
        Mesa existente = buscarPorId(id);
        existente.setNumero(mesa.getNumero());
        existente.setCapacidad(mesa.getCapacidad());
        existente.setDisponible(mesa.isDisponible());
        return mesaRepository.save(existente);
    }

    // Eliminar mesa
    public void eliminar(Long id) {
        mesaRepository.deleteById(id);
    }
}

