package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rappeurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;
}
