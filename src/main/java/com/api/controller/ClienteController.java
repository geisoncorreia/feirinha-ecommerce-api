package com.api.controller;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    final private ClienteService clienteService;

    @GetMapping("/clientes/")
    public ResponseEntity<List<PessoaDTO>> getAll() {
        log.info("findAllCustomers");
        if(clienteService.findAllCustomers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(clienteService.findAllCustomers());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<PessoaDTO> getClienteById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {
        log.info("getClienteById");
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @PostMapping(path = "/clientes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO clienteDTO) {
        log.info("Novo Cliente");
        return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/clientes/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PessoaDTO> update(@PathVariable(value = "id") UUID id, @RequestBody PessoaDTO pessoaDTO) {
        return new ResponseEntity<>(clienteService.update(id, pessoaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") UUID id) {
        clienteService.delete(id);
    }

}
