package com.co.programacion.ejemplosprintboot1.repositories;

import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByClienteId(Long clienteId);
}
