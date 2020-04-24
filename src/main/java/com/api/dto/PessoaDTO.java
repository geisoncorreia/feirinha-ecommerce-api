package com.api.dto;
import com.api.model.PessoaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDTO {

    private UUID id;
    private String nome;
    private Integer idade;
    private String email;
    private Integer tipoPessoa;
    private EnderecoDTO endereco;
}
