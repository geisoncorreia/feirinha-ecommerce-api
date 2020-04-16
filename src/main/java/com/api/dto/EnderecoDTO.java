package com.api.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private String logradouro;
    private String numero;
    private String cidade;
    private String UF;
}
