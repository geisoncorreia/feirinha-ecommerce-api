package com.api.controller;

import com.api.builder.Builder;
import com.api.builder.CampanhaBuilder;
import com.api.dto.CampanhaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.model.Campanha;
import com.api.repository.CampanhaRepository;
import com.api.repository.ClienteRepository;
import com.api.repository.ProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CampanhaController {

    private static final Logger logger = LogManager.getLogger(CampanhaController.class);

    private CampanhaRepository campanhaRepository;
    private ProdutoRepository produtoRepository;
    private ClienteRepository clienteRepository;
    private Builder<Campanha> builder;

    public CampanhaController(CampanhaRepository campanhaRepository,
                              ProdutoRepository produtoRepository,
                              ClienteRepository clienteRepository,
                              Builder<Campanha> builder) {
        this.campanhaRepository = campanhaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
        this.builder = builder;
    }

    @GetMapping("/campanhas/")
    public ResponseEntity<List<Campanha>> getAll() {
        if(campanhaRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        logger.info(campanhaRepository.findAll());
        return ResponseEntity.ok(campanhaRepository.findAll());
    }

    @GetMapping("/campanhas/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {

        Campanha campanha = campanhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campanha não encontrada para o id :: " + id));

        return ResponseEntity.ok().body(campanha);
    }

    @PostMapping(path = "/campanhas", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Campanha> create(@RequestBody CampanhaDTO campanhaDTO) {

        try {
            builder =
                    new CampanhaBuilder(produtoRepository, clienteRepository)
                            .addDataCricao(campanhaDTO.getDataCricao())
                            .addDescricao(campanhaDTO.getDescricao())
                            .addFornecedor(campanhaDTO.getFornecedor())
                            .addInteressados(campanhaDTO.getInteressados())
                            .addPreco(campanhaDTO.getPreco())
                            .addProduto(campanhaDTO.getProduto())
                            .addLocalEntrega(campanhaDTO.getLocalEntrega());

            final Campanha campanha = builder.build();
            this.campanhaRepository.save(campanha);
            return new ResponseEntity<Campanha>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Campanha>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
