package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Lieux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

    @Column
    String ville;

    @Column
    String pays;
}
