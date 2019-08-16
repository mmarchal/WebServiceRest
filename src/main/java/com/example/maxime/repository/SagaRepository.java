package com.example.maxime.repository;

import com.example.maxime.entities.Saga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SagaRepository extends JpaRepository<Saga, Long> {
}
