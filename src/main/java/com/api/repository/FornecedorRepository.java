package com.api.repository;

import com.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FornecedorRepository extends JpaRepository<Pessoa, UUID> {

    @Query(value = "select p.* from Pessoa p where p.tipo_pessoa = 2", nativeQuery=true)
    public List<Pessoa> findAllProviders();
}
