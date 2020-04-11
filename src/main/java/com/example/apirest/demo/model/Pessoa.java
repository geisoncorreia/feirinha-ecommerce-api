package com.example.apirest.demo.model;

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

}
