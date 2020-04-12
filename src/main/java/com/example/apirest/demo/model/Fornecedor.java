package com.example.apirest.demo.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column
    private String nome;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Pessoa pessoa;

}
