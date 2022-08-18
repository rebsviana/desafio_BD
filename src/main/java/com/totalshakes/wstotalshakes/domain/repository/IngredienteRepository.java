package com.totalshakes.wstotalshakes.domain.repository;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
}
