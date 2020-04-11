package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "campanha")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column
    private String descricao;

    @Column
    private String fornecedor;

    @Column
    private String produto;

    @Column
    private BigDecimal preco;

    @Column
    private Date dataFinal;

    @Column
    private Date dataCricao;

    @OneToMany
    private List<Cliente> interessados;
}
