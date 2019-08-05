package com.example.maxime.repository;

import com.example.maxime.entities.SeriesAnimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesAnimesRepository extends JpaRepository<SeriesAnimes, Long> {
}
