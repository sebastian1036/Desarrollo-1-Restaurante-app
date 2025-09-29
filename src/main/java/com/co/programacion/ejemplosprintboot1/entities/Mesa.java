package com.co.programacion.ejemplosprintboot1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int capacidad;
    private boolean disponible = true; // por defecto disponible
}

