package com.api.model;

import lombok.Data;
import org.hibernate.annotations.Where;

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
    @Where(clause = "fornecedor.tipoPessoa = 2")
    private Pessoa fornecedor;

    @ManyToOne
    private Preco preco;

    @Column
    private String descricao;
}
