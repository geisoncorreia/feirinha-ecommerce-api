package com.example.apirest.demo.builder;

import com.example.apirest.demo.model.Car;
import com.example.apirest.demo.model.Modelo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.UUID;
@Data
public class CarBuilder {

    private Integer ano;
    private String cor;
    private Modelo modelo;

    public CarBuilder defineAno(Integer ano) {
        setAno(ano);
        return this;
    }

    public CarBuilder defineCor(String cor) {
        setCor(cor);
        return this;
    }

    public CarBuilder defineModelo(Modelo modelo) {
        setModelo(modelo);
        return this;
    }

    public Car build() {

        Car car = new Car();
        car.setAno(ano);
        car.setCor(cor);
        car.setModelo(this.modelo);
        return car;
    }

}
