package com.api.controller;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.mapper.EnderecoMapper;
import com.api.model.Pessoa;
import com.api.repository.ClienteRepository;
import com.api.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ClienteController {

    final private ClienteRepository clienteRepository;
    final private EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

    @GetMapping("/clientes/")
    public ResponseEntity<List<Pessoa>> getAll() {
        if(clienteRepository.findAllCustomers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        log.info("findAllCustomers");
        return ResponseEntity.ok(clienteRepository.findAllCustomers());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Pessoa> getClienteById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        Pessoa cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id :: " + id));
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping(path = "/clientes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Pessoa> create(@RequestBody PessoaDTO pessoaDTO) {

        try {
            final Pessoa cliente = Pessoa.builder()
                    .email(pessoaDTO.getEmail())
                    .endereco(enderecoMapper.enderecoDtoToEndereco(pessoaDTO.getEndereco()))
                    .idade(pessoaDTO.getIdade())
                    .nome(pessoaDTO.getNome())
                    .tipoPessoa(pessoaDTO.getTipoPessoa()).build();

            this.clienteRepository.save(cliente);
            return new ResponseEntity<Pessoa>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
