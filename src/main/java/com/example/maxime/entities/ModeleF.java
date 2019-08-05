package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class ModeleF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nom")
    String nom;

    @Column(name = "image")
    String image;

    @Column(name = "acteur1")
    String acteur1;

    @Column(name = "acteur2")
    String acteur2;

    @Column(name = "annee")
    String annee;

    @Column(name = "synopsis", length = 1023)
    String synopsis;
}
