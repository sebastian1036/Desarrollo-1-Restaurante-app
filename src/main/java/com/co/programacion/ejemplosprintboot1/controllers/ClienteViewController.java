package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Cliente;
import com.co.programacion.ejemplosprintboot1.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteViewController {

    private final ClienteService clienteService;

    public ClienteViewController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        return "clientes"; // carga clientes.html
    }

    @PostMapping("/clientes")
    public String agregar(Cliente cliente) {
        clienteService.registrar(cliente);
        return "redirect:/clientes";
    }
}
