package com.cobranza.gestionclientesmicroservicios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cobranza.gestionclientesmicroservicios.entidades.Cliente;
import com.cobranza.gestionclientesmicroservicios.service.ClienteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        LocalDate fecha = LocalDate.now(); // Obtén la fecha actual
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define el formato
        String fechaComoTexto = fecha.format(formato); // Convierte la fecha a String
        cliente.setFechaRegistro(fechaComoTexto);
        
        return clienteService.guardarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.actualizarCliente(id, cliente));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
