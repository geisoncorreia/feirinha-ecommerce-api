package com.api.service;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.mapper.PessoaMapper;
import com.api.model.Pessoa;
import com.api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    final private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);

    @Override
    public List<PessoaDTO> findAllCustomers() {
        return mapper.listPessoaToListPessoaDto(
                clienteRepository.findAllCustomers());
    }

    @Override
    public PessoaDTO findById(UUID id) {
        return mapper.pessoaToPessoaDto(
                clienteRepository.findById(id).orElseThrow(
                        ResourceNotFoundException::new)
        );
    }

    @Override
    public PessoaDTO save(PessoaDTO cliente) {
        return mapper.pessoaToPessoaDto(
                clienteRepository.save(
                        mapper.pessoaDtoToPessoa(cliente)
                )
        );
    }
}
