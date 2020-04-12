package com.example.apirest.demo;

import com.example.apirest.demo.model.*;
import com.example.apirest.demo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

//@Component
public class BootstrapApp implements CommandLineRunner {

    private ClienteRepository clienteRepository;
    private PessoaRepository pessoaRepository;
    private FornecedorRepository fornecedorRepository;
    private PrecoRepository precoRepository;
    private ProdutoRepository produtoRepository;
    private CampanhaRepository campanhaRepository;

    public BootstrapApp(ClienteRepository clienteRepository,
                        PessoaRepository pessoaRepository,
                        FornecedorRepository fornecedorRepository,
                        PrecoRepository precoRepository,
                        ProdutoRepository produtoRepository,
                        CampanhaRepository campanhaRepository) {
        this.clienteRepository = clienteRepository;
        this.pessoaRepository = pessoaRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.precoRepository = precoRepository;
        this.produtoRepository = produtoRepository;
        this.campanhaRepository = campanhaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente = new Cliente();
        cliente.setNome("Luiza Correia");
        cliente.setPessoa(
                new Pessoa("Luiza Correia", 7, "luiza@gmail.com",
                        new Endereco("Rua Azul", "20", "Fortaleza", "CE")));

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Fornecedor 1");
        fornecedor.setPessoa(
                new Pessoa("Fornecedor 1", null, "fornecedor@gmail.com",
                        new Endereco("AV sarará", "758", "Fortaleza", "CE")));

        Preco preco = new Preco();
        preco.setPreco(new BigDecimal("70.00"));
        preco.setDataUltimaAlteracao(new Date());

        Produto produto = new Produto();
        produto.setDescricao("Castanha de Cajú orgânica natural");
        produto.setFornecedor(fornecedor);
        produto.setNome("Castanha de Cajú");
        produto.setPreco(preco);

        final Fornecedor fornecedorSalvo  = fornecedorRepository.save(fornecedor);
        final Cliente clienteSalvo = clienteRepository.save(cliente);
        final Preco precoSalvo = precoRepository.save(preco);
        final Produto produtoSalvo  = produtoRepository.save(produto);

        //Salvar campanha
        Campanha campanha = new Campanha();
        campanha.setDescricao("Venda de Castanha");
        campanha.setDataCricao(new Date());
        campanha.setLocalEntrega("COOPERATIVA");
        campanha.setFornecedor(fornecedorRepository.findById(fornecedorSalvo.getId()).get().getNome());
        campanha.setPreco(precoRepository.findById(precoSalvo.getId()).get().getPreco());
        campanha.setProduto(produtoRepository.findById(produtoSalvo.getId()).get());

        campanha.setInteressados(new ArrayList<>());
        campanha.getInteressados().add(clienteRepository
                .findById(clienteSalvo.getId()).get());

        campanhaRepository.save(campanha);
        campanhaRepository.flush();


    }

    private void criarCampanha(UUID pessoaSalvaId, UUID clienteSalvoId, UUID precoSalvoId, UUID produtoSalvoId, UUID fornecedorSalvoId) {


    }
}
