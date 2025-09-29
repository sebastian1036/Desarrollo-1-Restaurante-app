package com.co.programacion.ejemplosprintboot1.services;

import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import com.co.programacion.ejemplosprintboot1.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Crear reserva
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Listar reservas
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    // Buscar reserva por ID
    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));
    }

    // Actualizar reserva
    public Reserva actualizar(Long id, Reserva reserva) {
        Reserva existente = buscarPorId(id);
        existente.setFecha(reserva.getFecha());
        existente.setHora(reserva.getHora());
        existente.setPersonas(reserva.getPersonas());
        existente.setEstado(reserva.getEstado());
        existente.setCliente(reserva.getCliente());
        existente.setMesa(reserva.getMesa());
        return reservaRepository.save(existente);
    }

    // Cancelar/eliminar reserva
    public void cancelarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
