package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Avengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

    @Column
    String description;

    @Column
    String acteur;
}
