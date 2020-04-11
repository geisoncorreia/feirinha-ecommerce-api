package com.example.apirest.demo;

import com.example.apirest.demo.builder.CarBuilder;
import com.example.apirest.demo.builder.ModeloBuilder;
import com.example.apirest.demo.model.Car;
import com.example.apirest.demo.model.Fabricante;
import com.example.apirest.demo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapApp implements CommandLineRunner {

    private final CarRepository carRepository;

    public BootstrapApp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car punto = new CarBuilder()
                .defineAno(2020)
                .defineCor("Prata")
                .defineModelo(new ModeloBuilder()
                        .defineDescricao("Punto")
                        .defineFabricante(new Fabricante("FIAT"))
                        .build())
                .build();

        Car chevette = new CarBuilder()
                .defineAno(2020)
                .defineCor("Bege")
                .defineModelo(new ModeloBuilder()
                        .defineDescricao("Chevette")
                        .defineFabricante(new Fabricante("CHEVROLET"))
                        .build())
                .build();

        carRepository.save(punto);
        carRepository.save(chevette);
        carRepository.flush();

        System.out.println("QTD carros: " + carRepository.count());


    }
}
