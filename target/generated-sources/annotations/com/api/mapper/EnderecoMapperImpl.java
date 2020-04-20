package com.api.mapper;

import com.api.dto.EnderecoDTO;
import com.api.model.Endereco;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-20T20:36:30-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public Endereco enderecoDtoToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setLogradouro( enderecoDTO.getLogradouro() );
        endereco.setNumero( enderecoDTO.getNumero() );
        endereco.setCidade( enderecoDTO.getCidade() );
        endereco.setUF( enderecoDTO.getUF() );

        return endereco;
    }

    @Override
    public EnderecoDTO enderecoToEnderecoDto(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setLogradouro( endereco.getLogradouro() );
        enderecoDTO.setNumero( endereco.getNumero() );
        enderecoDTO.setCidade( endereco.getCidade() );
        enderecoDTO.setUF( endereco.getUF() );

        return enderecoDTO;
    }
}
