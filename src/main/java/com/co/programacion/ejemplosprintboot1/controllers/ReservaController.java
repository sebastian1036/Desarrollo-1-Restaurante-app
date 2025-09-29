package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import com.co.programacion.ejemplosprintboot1.services.ReservaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Crear reserva
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.crearReserva(reserva);
    }

    // Listar reservas
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.obtenerReservas();
    }

    // Buscar reserva por id
    @GetMapping("/{id}")
    public Reserva buscarPorId(@PathVariable Long id) {
        return reservaService.buscarPorId(id);
    }

    // Actualizar reserva
    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.actualizar(id, reserva);
    }

    // Cancelar/eliminar reserva
    @DeleteMapping("/{id}")
    public void cancelar(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
    }
}
