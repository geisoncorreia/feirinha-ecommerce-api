package com.api.builder;

import com.api.controller.CampanhaController;
import com.api.exception.ResourceNotFoundException;
import com.api.model.Campanha;
import com.api.model.Produto;
import com.api.repository.ClienteRepository;
import com.api.repository.PessoaRepository;
import com.api.repository.ProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class CampanhaBuilder implements Builder<Campanha> {

    private static final Logger logger = LogManager.getLogger(CampanhaBuilder.class);

    private ProdutoRepository produtoRepository;
    private ClienteRepository clienteRepository;

    private String descricao;
    private String fornecedor;
    private UUID produto;
    private BigDecimal preco;
    private Date dataCricao;
    private String localEntrega;
    private List<UUID> interessados;

    public CampanhaBuilder() { }

    public CampanhaBuilder(ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public CampanhaBuilder addDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public CampanhaBuilder addFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
        return this;
    }

    public CampanhaBuilder addProduto(UUID produto) {
        this.produto = produto;
        return this;
    }

    public CampanhaBuilder addPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public CampanhaBuilder addDataCricao(Date dataCricao) {
        this.dataCricao = dataCricao;
        return this;
    }

    public CampanhaBuilder addLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
        return this;
    }

    public CampanhaBuilder addInteressados(List<UUID> interessados) {
        this.interessados = interessados;
        return this;
    }

    @Override
    public Campanha build() {

        Campanha campanha = new Campanha();
        campanha.setDataCricao(this.dataCricao);
        campanha.setDescricao(this.descricao);
        campanha.setPreco(this.preco);
        final Produto produto;

        try {

            produto = produtoRepository.findById(this.produto)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Produto não encontrado para o id :: " + this.produto));

            campanha.setInteressados(new ArrayList<>());
            this.interessados.forEach(i -> {
                try {
                    campanha.getInteressados().add(
                            clienteRepository.findById(i).orElseThrow(() -> new ResourceNotFoundException(
                                    "Cliente não encontrado para o id :: " + i)));
                } catch (ResourceNotFoundException e) {
                    logger.error(e.getMessage(), e);
                }
            });

            campanha.setProduto(produto);
            campanha.setFornecedor(this.fornecedor);
            campanha.setLocalEntrega(this.localEntrega);

        } catch (ResourceNotFoundException e) {
            logger.error(e.getMessage(), e);
        }

        return campanha;
    }
}
