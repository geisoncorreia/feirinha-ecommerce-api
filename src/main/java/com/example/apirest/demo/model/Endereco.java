package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String cidade, String UF) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.UF = UF;
    }

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String cidade;

    @Column
    private String UF;

}
