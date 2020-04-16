package com.api.builder;

import com.api.dto.EnderecoDTO;
import com.api.model.Endereco;
import com.api.model.Pessoa;
import com.api.model.PessoaEnum;

public class ClienteBuilder implements Builder<Pessoa> {

    private String nome;
    private Integer idade;
    private String email;
    private PessoaEnum tipoPessoa;
    private EnderecoDTO endereco;

    public ClienteBuilder addNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder addIdade(Integer idade) {
        this.idade = idade;
        return this;
    }

    public ClienteBuilder addTipoPessoa(PessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
        return this;
    }

    public ClienteBuilder addEmail(String email) {
        this.email = email;
        return this;
    }

    public ClienteBuilder addEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
        return this;
    }

    @Override
    public Pessoa build() {
        Pessoa cliente = new Pessoa();
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setIdade(this.idade);
        cliente.setTipoPessoa(this.tipoPessoa);
        cliente.setEndereco(new Endereco());
        cliente.getEndereco().setCidade(this.endereco.getCidade());
        cliente.getEndereco().setLogradouro(this.endereco.getLogradouro());
        cliente.getEndereco().setNumero(this.endereco.getNumero());
        cliente.getEndereco().setUF(this.endereco.getUF());
        return cliente;
    }
}
