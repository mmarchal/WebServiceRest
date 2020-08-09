package com.example.maxime.models;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class TroisColonnes {

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

}
