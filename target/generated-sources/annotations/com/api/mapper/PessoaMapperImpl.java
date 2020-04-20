package com.api.mapper;

import com.api.dto.EnderecoDTO;
import com.api.dto.PessoaDTO;
import com.api.dto.PessoaDTO.PessoaDTOBuilder;
import com.api.model.Endereco;
import com.api.model.Endereco.EnderecoBuilder;
import com.api.model.Pessoa;
import com.api.model.Pessoa.PessoaBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-20T20:37:17-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public Pessoa pessoaDtoToPessoa(PessoaDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        PessoaBuilder pessoa = Pessoa.builder();

        pessoa.nome( pessoaDTO.getNome() );
        pessoa.idade( pessoaDTO.getIdade() );
        pessoa.email( pessoaDTO.getEmail() );
        pessoa.tipoPessoa( pessoaDTO.getTipoPessoa() );
        pessoa.endereco( enderecoDTOToEndereco( pessoaDTO.getEndereco() ) );

        return pessoa.build();
    }

    @Override
    public PessoaDTO pessoaToPessoaDto(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTOBuilder pessoaDTO = PessoaDTO.builder();

        pessoaDTO.nome( pessoa.getNome() );
        pessoaDTO.idade( pessoa.getIdade() );
        pessoaDTO.email( pessoa.getEmail() );
        pessoaDTO.tipoPessoa( pessoa.getTipoPessoa() );
        pessoaDTO.endereco( enderecoToEnderecoDTO( pessoa.getEndereco() ) );

        return pessoaDTO.build();
    }

    @Override
    public List<Pessoa> listaPessoaDtoToListPessoa(List<PessoaDTO> listPessoaDTO) {
        if ( listPessoaDTO == null ) {
            return null;
        }

        List<Pessoa> list = new ArrayList<Pessoa>( listPessoaDTO.size() );
        for ( PessoaDTO pessoaDTO : listPessoaDTO ) {
            list.add( pessoaDtoToPessoa( pessoaDTO ) );
        }

        return list;
    }

    @Override
    public List<PessoaDTO> listPessoaToListPessoaDto(List<Pessoa> listPessoa) {
        if ( listPessoa == null ) {
            return null;
        }

        List<PessoaDTO> list = new ArrayList<PessoaDTO>( listPessoa.size() );
        for ( Pessoa pessoa : listPessoa ) {
            list.add( pessoaToPessoaDto( pessoa ) );
        }

        return list;
    }

    protected Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO) {
        if ( enderecoDTO == null ) {
            return null;
        }

        EnderecoBuilder endereco = Endereco.builder();

        endereco.logradouro( enderecoDTO.getLogradouro() );
        endereco.numero( enderecoDTO.getNumero() );
        endereco.cidade( enderecoDTO.getCidade() );
        endereco.UF( enderecoDTO.getUF() );

        return endereco.build();
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
