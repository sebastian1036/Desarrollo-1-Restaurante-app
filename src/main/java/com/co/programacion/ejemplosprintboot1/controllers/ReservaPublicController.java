package com.co.programacion.ejemplosprintboot1.controllers;

import com.co.programacion.ejemplosprintboot1.entities.Cliente;
import com.co.programacion.ejemplosprintboot1.entities.Mesa;
import com.co.programacion.ejemplosprintboot1.entities.Reserva;
import com.co.programacion.ejemplosprintboot1.repositories.ClienteRepository;
import com.co.programacion.ejemplosprintboot1.repositories.MesaRepository;
import com.co.programacion.ejemplosprintboot1.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Controller
public class ReservaPublicController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    // 👉 Muestra el formulario
    @GetMapping("/reservar")
    public String mostrarFormulario() {
        return "reservar";
    }

    // 👉 Procesa el formulario
    @PostMapping("/reservar")
    public String procesarReserva(
            @RequestParam String nombre,
            @RequestParam String telefono,
            @RequestParam String email,
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam int personas,
            Model model) {

        LocalDate fechaReserva = LocalDate.parse(fecha);

        // Buscar cliente o crearlo
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setEmail(email);
        }
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        clienteRepository.save(cliente);

        // Buscar mesa disponible (bloqueo por TODO el día)
        Optional<Mesa> mesaOpt = mesaRepository.findAll().stream()
                .filter(m -> m.isDisponible() && m.getCapacidad() >= personas)
                .filter(m -> reservaRepository.findByMesaIdAndFecha(m.getId(), fechaReserva).isEmpty())
                .findFirst();

        if (mesaOpt.isEmpty()) {
            model.addAttribute("mensaje", "❌ Lo sentimos, no hay mesas disponibles para esa fecha.");
            return "reservar";
        }

        Mesa mesa = mesaOpt.get();

        // Crear reserva
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setMesa(mesa);
        reserva.setFecha(fechaReserva);
        reserva.setHora(LocalTime.parse(hora)); // Informativo
        reserva.setPersonas(personas);
        reserva.setEstado("Pendiente");

        reservaRepository.save(reserva);

        // Mensaje de éxito
        model.addAttribute("mensaje", "✅ Reserva creada con éxito. Mesa asignada: " + mesa.getNumero());
        return "reservar";
    }
}
