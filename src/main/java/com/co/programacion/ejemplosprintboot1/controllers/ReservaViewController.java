package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import com.co.programacion.ejemplosprintboot1.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservaViewController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/reservas")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas";
    }

    @PostMapping("/reservas/cambiarEstado")
    public String cambiarEstado(@RequestParam Long id, @RequestParam String estado) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
            reserva.setEstado(estado);
            reservaRepository.save(reserva);
        }
        return "redirect:/reservas";
    }
}

