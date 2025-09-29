package com.co.programacion.ejemplosprintboot1.repositories;

import com.co.programacion.ejemplosprintboot1.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para buscar un cliente por su email
    Cliente findByEmail(String email);
}

