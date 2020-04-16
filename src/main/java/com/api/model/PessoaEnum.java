package com.api.model;

import lombok.Getter;

@Getter
public enum PessoaEnum {

    CLIENTE(1), FORNECEDOR(2);

    private int valor;

    PessoaEnum(int tipo) {
        this.valor = tipo;
    }

}
