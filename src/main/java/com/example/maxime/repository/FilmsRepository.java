package com.example.maxime.repository;

import com.example.maxime.entities.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmsRepository extends JpaRepository<Films, Long> {
}
