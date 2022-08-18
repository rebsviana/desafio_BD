package com.totalshakes.wstotalshakes.domain.repository;

import com.totalshakes.wstotalshakes.domain.model.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Integer> {
}
