package com.api.mapper;

import com.api.dto.EnderecoDTO;
import com.api.dto.PessoaDTO;
import com.api.model.Endereco;
import com.api.model.Pessoa;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-18T22:33:31-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa clienteDTOToCliente(PessoaDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setNome( pessoaDTO.getNome() );
        pessoa.setIdade( pessoaDTO.getIdade() );
        pessoa.setEmail( pessoaDTO.getEmail() );
        pessoa.setTipoPessoa( pessoaDTO.getTipoPessoa() );
        pessoa.setEndereco( enderecoDTOToEndereco( pessoaDTO.getEndereco() ) );

        return pessoa;
    }

    @Override
    public PessoaDTO pessoaDTOToPessoa(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setNome( pessoa.getNome() );
        pessoaDTO.setIdade( pessoa.getIdade() );
        pessoaDTO.setEmail( pessoa.getEmail() );
        pessoaDTO.setTipoPessoa( pessoa.getTipoPessoa() );
        pessoaDTO.setEndereco( enderecoToEnderecoDTO( pessoa.getEndereco() ) );

        return pessoaDTO;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
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

    protected EnderecoDTO enderecoToEnderecoDTO(Endereco endereco) {
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
