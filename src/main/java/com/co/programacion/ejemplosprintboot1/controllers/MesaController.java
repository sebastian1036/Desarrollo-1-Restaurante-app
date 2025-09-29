package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Mesa;
import com.co.programacion.ejemplosprintboot1.services.MesaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    private final MesaService mesaService;

    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    // Crear mesa
    @PostMapping
    public Mesa registrar(@RequestBody Mesa mesa) {
        return mesaService.registrar(mesa);
    }

    // Listar mesas
    @GetMapping
    public List<Mesa> listar() {
        return mesaService.listar();
    }

    // Buscar mesa por id
    @GetMapping("/{id}")
    public Mesa buscarPorId(@PathVariable Long id) {
        return mesaService.buscarPorId(id);
    }

    // Actualizar mesa
    @PutMapping("/{id}")
    public Mesa actualizar(@PathVariable Long id, @RequestBody Mesa mesa) {
        return mesaService.actualizar(id, mesa);
    }

    // Eliminar mesa
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mesaService.eliminar(id);
    }
}
