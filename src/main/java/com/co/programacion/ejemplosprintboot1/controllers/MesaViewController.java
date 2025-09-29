package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Mesa;
import com.co.programacion.ejemplosprintboot1.services.MesaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MesaViewController {

    private final MesaService mesaService;

    public MesaViewController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/mesas")
    public String listar(Model model) {
        model.addAttribute("mesas", mesaService.listar());
        return "mesas"; // carga mesas.html
    }

    @PostMapping("/mesas")
    public String agregar(Mesa mesa) {
        mesaService.registrar(mesa);
        return "redirect:/mesas";
    }
}
