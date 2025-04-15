package br.com.fiap.ApiPetShop.controller;
import br.com.fiap.ApiPetShop.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.ApiPetShop.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody @Valid Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarClientePorId(@PathVariable Long id) {
        return clienteService.listarClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody @Valid Cliente clienteAtualizado) {
        return clienteService.atualizarCliente(id, clienteAtualizado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCliente(@PathVariable Long id) {
        if (clienteService.removerCliente(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody Cliente loginRequest) {
        Optional<Cliente> cliente = clienteService.listarClientes().stream()
                .filter(c -> c.getEmail().equals(loginRequest.getEmail()) && c.getSenha().equals(loginRequest.getSenha()))
                .findFirst();
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }
}
