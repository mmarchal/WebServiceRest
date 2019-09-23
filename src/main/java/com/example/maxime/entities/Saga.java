package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Saga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

    @Column
    String nombreFilms;

    @Column(length = 2047)
    String contenu;

}
