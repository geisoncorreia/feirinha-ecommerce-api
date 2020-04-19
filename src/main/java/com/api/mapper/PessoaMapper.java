package com.api.mapper;

import com.api.dto.PessoaDTO;
import com.api.model.Pessoa;
import org.mapstruct.Mapper;

@Mapper
public interface PessoaMapper {

    Pessoa clienteDTOToCliente(PessoaDTO pessoaDTO);

    PessoaDTO pessoaDTOToPessoa(Pessoa pessoa);
}
