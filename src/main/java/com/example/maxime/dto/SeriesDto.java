package com.example.maxime.dto;

import lombok.Data;

@Data
public class SeriesDto {
    Long id;

    String nom;

    String image;

    String anneeDebut;

    String anneeFin;
}
