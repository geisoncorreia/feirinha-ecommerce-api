package com.api.service;

import com.api.dto.PessoaDTO;
import java.util.List;
import java.util.UUID;

public interface FornecedorService {

    List<PessoaDTO> findAllProviders();

    PessoaDTO findById(UUID id);

    PessoaDTO save(PessoaDTO fornecedor);
}
