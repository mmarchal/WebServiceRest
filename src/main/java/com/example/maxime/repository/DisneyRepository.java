package com.example.maxime.repository;

import com.example.maxime.entities.Disney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisneyRepository extends JpaRepository<Disney, Long> {
}
