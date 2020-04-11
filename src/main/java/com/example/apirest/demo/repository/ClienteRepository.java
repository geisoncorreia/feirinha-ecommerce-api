package com.example.apirest.demo.repository;

import com.example.apirest.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

//    Optional<Car> findByAno(Integer ano);
}
