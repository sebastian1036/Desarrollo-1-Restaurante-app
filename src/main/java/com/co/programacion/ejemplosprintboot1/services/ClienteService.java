package com.co.programacion.ejemplosprintboot1.services;

import com.co.programacion.ejemplosprintboot1.entities.Cliente;
import com.co.programacion.ejemplosprintboot1.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Crear cliente
    public Cliente registrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Listar todos los clientes
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }

    // Actualizar cliente
    public Cliente actualizar(Long id, Cliente cliente) {
        Cliente existente = buscarPorId(id);
        existente.setNombre(cliente.getNombre());
        existente.setEmail(cliente.getEmail());
        existente.setTelefono(cliente.getTelefono());
        existente.setBloqueado(cliente.isBloqueado());
        return clienteRepository.save(existente);
    }

    // Eliminar cliente
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
