package com.api.repository;

import com.api.model.Preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, UUID> {
}
