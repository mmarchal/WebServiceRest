package com.example.maxime.models;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class DeuxColonnes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nom")
    String nom;

    @Column(name = "image")
    String image;
}
