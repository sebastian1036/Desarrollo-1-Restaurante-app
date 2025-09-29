package com.co.programacion.ejemplosprintboot1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private boolean bloqueado = false;  // por defecto no bloqueado
}
