package com.api.service;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.mapper.PessoaMapper;
import com.api.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FornecedorServiceImpl implements FornecedorService {

    final private FornecedorRepository fornecedorRepository;
    final private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    @Override
    public List<PessoaDTO> findAllProviders() {
        return mapper.listPessoaToListPessoaDto(
                fornecedorRepository.findAllProviders()
        );
    }

    @Override
    public PessoaDTO findById(UUID id) {
        return mapper.pessoaToPessoaDto(
                fornecedorRepository.findById(id).orElseThrow(ResourceNotFoundException::new)
        );
    }

    @Override
    public PessoaDTO save(PessoaDTO fornecedor) {
        return mapper.pessoaToPessoaDto(
                fornecedorRepository.save(mapper.pessoaDtoToPessoa(fornecedor)
                )
        );
    }
}
