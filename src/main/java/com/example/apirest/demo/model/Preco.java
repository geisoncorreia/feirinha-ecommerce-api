package com.example.apirest.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "preco")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column
    private BigDecimal preco;

    @Column
    private Date dataUltimaAlteracao;
}
