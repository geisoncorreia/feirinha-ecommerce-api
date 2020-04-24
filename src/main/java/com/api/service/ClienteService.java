package com.api.service;

import com.api.dto.PessoaDTO;
import com.api.model.Pessoa;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    
    List<PessoaDTO> findAllCustomers();

    PessoaDTO findById(UUID id);

    PessoaDTO save(PessoaDTO cliente);

    PessoaDTO update(UUID id, PessoaDTO pessoaDTO);

    void delete(UUID id);
}
