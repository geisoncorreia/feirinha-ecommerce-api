package com.example.apirest.demo.repository;

import com.example.apirest.demo.model.Car;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarRepositoryIT {

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void deveriaBuscarCarPorAno() throws Exception {

        Optional<Car> car = carRepository.findByAno(1970);
        Assert.assertEquals(car.get().getModelo().getDescricao(), "Maverick");

    }
}