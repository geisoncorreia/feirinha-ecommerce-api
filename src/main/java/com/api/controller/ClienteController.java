package com.api.controller;

import com.api.builder.Builder;
import com.api.builder.ClienteBuilder;
import com.api.dto.ClienteDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.model.Endereco;
import com.api.model.Pessoa;
import com.api.repository.ClienteRepository;
import com.api.repository.PessoaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    private ClienteRepository clienteRepository;
    private PessoaRepository pessoaRepository;


    public ClienteController(ClienteRepository clienteRepository, PessoaRepository pessoaRepository) {
        this.clienteRepository = clienteRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Pessoa> getClienteById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {

        Pessoa cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id :: " + id));

        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping(path = "/clientes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Pessoa> salvar(@RequestBody ClienteDTO clienteDTO) {

        try {

            Builder<Pessoa> clienteBuilder =
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
