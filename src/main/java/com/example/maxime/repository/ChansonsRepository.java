package com.example.maxime.repository;

import com.example.maxime.entities.Chansons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChansonsRepository extends JpaRepository<Chansons, Long> {
}
