package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column
    private String nome;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToOne
    private Preco preco;

    @Column
    private String descricao;
}
