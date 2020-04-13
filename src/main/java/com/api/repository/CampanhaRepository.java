package com.api.repository;

import com.api.model.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, UUID> {
}
