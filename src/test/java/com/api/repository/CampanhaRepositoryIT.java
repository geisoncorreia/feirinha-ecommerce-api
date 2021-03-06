package com.api.repository;

import com.api.model.Campanha;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@Sql("data.sql")
public class CampanhaRepositoryIT {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CampanhaRepository campanhaRepository;

    @Autowired
    private PrecoRepository precoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() { }

    @Test
    public void deveriaCriarCampanha() throws Exception {

        Campanha campanha = new Campanha();
        campanha.setDescricao("Venda de Castanha");
        campanha.setDataCricao(new Date());
        campanha.setFornecedor(fornecedorRepository.
                findById(UUID
                        .fromString("e9a4fd4a-118e-49db-a473-4c6607d4ace7")).get().getNome());
        campanha.setPreco(precoRepository
                .findById(UUID
                        .fromString("b8627e52-ddf2-4bc2-a833-4003d632bcbd")).get().getPreco());
        campanha.setProduto(produtoRepository
                .findById(UUID
                        .fromString("b43cbb2d-efbe-4d60-a455-023ee650ddfa")).get());

        campanha.setInteressados(new ArrayList<>());
        campanha.getInteressados().add(clienteRepository
                .findById(UUID
                        .fromString("14ec51ec-5bef-4ae3-90c4-c862803fdcbd")).get());

        campanhaRepository.save(campanha);
        campanhaRepository.flush();

        Assert.assertTrue(campanha.getId() != null);
        Assert.assertEquals(campanha.getDescricao(), "Venda de Castanha");
        Assert.assertEquals(campanha.getFornecedor(), "Fornecedor 1");
        Assert.assertEquals(campanha.getPreco(), new BigDecimal("50.00"));


    }

}
