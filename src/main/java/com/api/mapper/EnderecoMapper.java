package com.api.mapper;

import com.api.dto.EnderecoDTO;
import com.api.model.Endereco;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper {

    Endereco enderecoDtoToEndereco(EnderecoDTO enderecoDTO);

    EnderecoDTO enderecoToEnderecoDto(Endereco endereco);
}
