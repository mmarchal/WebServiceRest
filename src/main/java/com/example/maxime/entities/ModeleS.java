package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class ModeleS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nom")
    String nom;

    @Column(name = "image")
    String image;

    @Column(name = "anneeDebut")
    String anneeDebut;

    @Column(name = "anneeFin")
    String anneeFin;
}
