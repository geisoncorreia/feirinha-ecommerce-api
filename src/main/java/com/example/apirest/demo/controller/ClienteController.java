package com.example.apirest.demo.controller;

import com.example.apirest.demo.exception.ResourceNotFoundException;
import com.example.apirest.demo.model.Cliente;
import com.example.apirest.demo.model.Pessoa;
import com.example.apirest.demo.repository.ClienteRepository;
import com.example.apirest.demo.repository.PessoaRepository;
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
