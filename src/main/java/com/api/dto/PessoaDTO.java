package com.api.dto;
import com.api.model.PessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDTO {

    private String nome;
    private Integer idade;
    private String email;
    private PessoaEnum tipoPessoa;
    private EnderecoDTO endereco;
}
