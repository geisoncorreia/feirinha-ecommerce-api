package com.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @ManyToOne
    private Produto produto;

    @Column
    private BigDecimal preco;

    @Column
    private Date dataFinal;

    @Column
    private Date dataCricao;

    @Column
    private String localEntrega;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Pessoa> interessados;
}
