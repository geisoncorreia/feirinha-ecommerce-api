package com.api.controller;

import com.api.exception.ResourceNotFoundException;
import com.api.model.Campanha;
import com.api.repository.CampanhaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CampanhaController {

    private CampanhaRepository campanhaRepository;

    public CampanhaController(CampanhaRepository campanhaRepository) {
        this.campanhaRepository = campanhaRepository;
    }

    @GetMapping("/campanha/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable(value = "id") UUID id) throws ResourceNotFoundException {

        Campanha campanha = campanhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campanha não encontrada para o id :: " + id));

        return ResponseEntity.ok().body(campanha);
    }


}
