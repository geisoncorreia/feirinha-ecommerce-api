package com.example.apirest.demo.builder;

import com.example.apirest.demo.model.Fabricante;
import com.example.apirest.demo.model.Modelo;
import lombok.Data;

@Data
public class ModeloBuilder {

    private String descricao;
    private Fabricante fabricante;

    public ModeloBuilder defineDescricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public ModeloBuilder defineFabricante(Fabricante fabricante) {
        setFabricante(fabricante);
        return this;
    }

    public Modelo build() {
        Modelo modelo = new Modelo();
        modelo.setFabricante(this.fabricante);
        modelo.setDescricao(this.descricao);
        return modelo;
    }

}
