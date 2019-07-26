package com.example.maxime.repository;

import com.example.maxime.entities.Avengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvengersRepository extends JpaRepository<Avengers, Long> {
}
