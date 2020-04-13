package com.api.controller;

import com.api.model.Cliente;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.ClienteRepository;
import com.api.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private PessoaRepository pessoaRepository;

    public ClienteController(ClienteRepository clienteRepository, PessoaRepository pessoaRepository) {
        this.clienteRepository = clienteRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id :: " + id));

        return ResponseEntity.ok().body(cliente);
    }


}
