package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "FABRICANTE")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String descricao;

    public Fabricante(String descricao) {
        setDescricao(descricao);
    }

    public Fabricante(){};
}
