package com.co.programacion.ejemplosprintboot1.repositories;

import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Buscar reservas por cliente
    List<Reserva> findByClienteId(Long clienteId);

    // Buscar reservas de una mesa en una fecha específica (ignora la hora)
    @Query("SELECT r FROM Reserva r WHERE r.mesa.id = :mesaId AND r.fecha = :fecha")
    List<Reserva> findByMesaIdAndFecha(Long mesaId, LocalDate fecha);
}

