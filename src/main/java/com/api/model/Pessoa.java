package com.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.h2.api.DatabaseEventListener;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @Column(nullable = false)
    private Integer tipoPessoa;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.PERSIST, org.hibernate.annotations.CascadeType.MERGE})
    private Endereco endereco;

    @Column()
    private Date dataExclusao;

}
