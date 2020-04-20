package com.api.mapper;

import com.api.dto.PessoaDTO;
import com.api.model.Pessoa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PessoaMapper {

    Pessoa pessoaDtoToPessoa(PessoaDTO pessoaDTO);

    PessoaDTO pessoaToPessoaDto(Pessoa pessoa);

    List<Pessoa> listaPessoaDtoToListPessoa(List<PessoaDTO> listPessoaDTO);

    List<PessoaDTO> listPessoaToListPessoaDto(List<Pessoa> listPessoa);


}
