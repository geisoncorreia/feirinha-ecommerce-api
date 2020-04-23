package com.api.controller;

import com.api.dto.CampanhaDTO;
import com.api.exception.ResourceNotFoundException;
import com.api.model.Campanha;
import com.api.model.Produto;
import com.api.repository.CampanhaRepository;
import com.api.repository.ClienteRepository;
import com.api.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CampanhaController {

    final private CampanhaRepository campanhaRepository;
    final private ProdutoRepository produtoRepository;
    final private ClienteRepository clienteRepository;

    @GetMapping("/campanhas/")
    public ResponseEntity<List<Campanha>> getAll() {
        if(campanhaRepository.findAll().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        log.info("findAll()");
        return ResponseEntity.ok(campanhaRepository.findAll());
    }

    @GetMapping("/campanhas/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {

        Campanha campanha = campanhaRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return ResponseEntity.ok().body(campanha);
    }

    @PostMapping(path = "/campanhas", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Campanha> create(@RequestBody CampanhaDTO campanhaDTO) {

        try {

            final Produto produto = produtoRepository.findById(campanhaDTO.getProduto())
                    .orElseThrow(ResourceNotFoundException::new);

            final Campanha campanha = Campanha.builder()
                    .dataCricao(campanhaDTO.getDataCricao())
                    .descricao(campanhaDTO.getDescricao())
                    .localEntrega(campanhaDTO.getLocalEntrega())
                    .preco(campanhaDTO.getPreco())
                    .fornecedor(campanhaDTO.getFornecedor())
                    .produto(produto)
                    .build();

            campanhaDTO.getInteressados().forEach(i -> {
                try {
                    campanha.getInteressados().add(
                            clienteRepository.findById(i).orElseThrow(ResourceNotFoundException::new));
                } catch (ResourceNotFoundException e) {
                    log.error(e.getMessage(), e);
                }
            });

            this.campanhaRepository.save(campanha);
            return new ResponseEntity<Campanha>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Campanha>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
