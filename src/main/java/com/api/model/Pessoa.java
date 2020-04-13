package com.api.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column()
    private Integer idade;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, Integer idade, String email, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.endereco = endereco;
    }


}
