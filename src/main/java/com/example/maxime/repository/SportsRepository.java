package com.example.maxime.repository;

import com.example.maxime.entities.Sports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsRepository extends JpaRepository<Sports, Long> {
}
