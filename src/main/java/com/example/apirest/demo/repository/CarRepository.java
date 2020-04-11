package com.example.apirest.demo.repository;

import com.example.apirest.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    Optional<Car> findByAno(Integer ano);
}
