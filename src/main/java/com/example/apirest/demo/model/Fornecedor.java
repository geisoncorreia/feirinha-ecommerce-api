package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    private Produto produto;
}
