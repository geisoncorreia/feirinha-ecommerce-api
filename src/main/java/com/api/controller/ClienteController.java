package com.api.controller;

import com.api.builder.Builder;
import com.api.builder.ClienteBuilder;
import com.api.dto.ClienteDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.model.Campanha;
import com.api.model.Endereco;
import com.api.model.Pessoa;
import com.api.repository.ClienteRepository;
import com.api.repository.PessoaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    private ClienteRepository clienteRepository;
    private PessoaRepository pessoaRepository;
    private Builder<Pessoa> clienteBuilder;

    public ClienteController(ClienteRepository clienteRepository,
                             PessoaRepository pessoaRepository,
                             Builder<Pessoa> clienteBuilder) {
        this.clienteRepository = clienteRepository;
        this.pessoaRepository = pessoaRepository;
        this.clienteBuilder = clienteBuilder;
    }

    @GetMapping("/clientes/")
    public ResponseEntity<List<Pessoa>> getAll() {
        if(clienteRepository.findAllCustomers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        logger.info(clienteRepository.findAllCustomers());
        return ResponseEntity.ok(clienteRepository.findAllCustomers());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Pessoa> getClienteById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        Pessoa cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id :: " + id));
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping(path = "/clientes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Pessoa> create(@RequestBody ClienteDTO clienteDTO) {

        try {
            clienteBuilder =
                    new ClienteBuilder()
                            .addEmail(clienteDTO.getEmail())
                            .addEndereco(clienteDTO.getEndereco())
                            .addIdade(clienteDTO.getIdade())
                            .addNome(clienteDTO.getNome())
                            .addTipoPessoa(clienteDTO.getTipoPessoa());

            final Pessoa cliente = clienteBuilder.build();
            this.clienteRepository.save(cliente);
            return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
