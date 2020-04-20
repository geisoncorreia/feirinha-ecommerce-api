package com.api.controller;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.mapper.EnderecoMapper;
import com.api.model.Pessoa;
import com.api.repository.FornecedorRepository;
import com.api.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class FornecedorController {

    final private FornecedorService fornecedorService;

    @GetMapping("/fornecedores/")
    public ResponseEntity<List<PessoaDTO>> getAll() {
        if(fornecedorService.findAllProviders().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        log.info("findAllProviders()");
        return ResponseEntity.ok(fornecedorService.findAllProviders());
    }

    @GetMapping("/fornecedores/{id}")
    public ResponseEntity<PessoaDTO> getProvidersById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        log.info("getProvidersById()");
        return ResponseEntity.ok().body(fornecedorService.findById(id));
    }

    @PostMapping(path = "/fornecedores", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok().body(fornecedorService.save(pessoaDTO));
    }
}
