package com.example.maxime.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Jeux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

}
