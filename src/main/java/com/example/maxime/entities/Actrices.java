package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Actrices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

    @Column
    String film1;

    @Column
    String film2;
}
