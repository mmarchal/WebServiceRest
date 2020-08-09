package com.example.maxime.models;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class CinqColonnes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nom")
    String nom;

    @Column(name = "image")
    String image;

    @Column(name = "colonne1")
    String colonne1;

    @Column(name = "colonne2")
    String colonne2;

    @Column(name = "colonne3")
    String colonne3;
}
