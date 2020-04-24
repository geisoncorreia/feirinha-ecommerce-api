package com.api.service;

import com.api.dto.PessoaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.mapper.EnderecoMapper;
import com.api.mapper.PessoaMapper;
import com.api.model.Pessoa;
import com.api.repository.ClienteRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    final private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);
    final private EnderecoMapper enderecoMapper = Mappers.getMapper(EnderecoMapper.class);

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

    @Override
    public PessoaDTO update(UUID id, PessoaDTO pessoaDTO) {
        final Pessoa cliente = clienteRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        cliente.setTipoPessoa(pessoaDTO.getTipoPessoa());
        cliente.setIdade(pessoaDTO.getIdade());
        cliente.setEmail(pessoaDTO.getEmail());
        cliente.setEndereco(enderecoMapper.enderecoDtoToEndereco(pessoaDTO.getEndereco()));

        return mapper.pessoaToPessoaDto(clienteRepository.save(cliente));
    }

    @Override
    public void delete(UUID id) {
        final Pessoa cliente = clienteRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        cliente.setDataExclusao(new Date());
        clienteRepository.save(cliente);
    }
}
