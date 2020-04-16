package com.api.dto;
import com.api.model.PessoaEnum;
import lombok.Data;

@Data
public class ClienteDTO {

    private String nome;
    private Integer idade;
    private String email;
    private PessoaEnum tipoPessoa;
    private EnderecoDTO endereco;
}
