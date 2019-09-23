package com.example.maxime.repository;

import com.example.maxime.entities.SuperHeros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHerosRepository extends JpaRepository<SuperHeros, Long> {
}
