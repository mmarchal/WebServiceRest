package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SUPERHEROS")
public class SuperHeros {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        Long id;

        @Column
        String nom;

        @Column
        String image;

        @Column
        String pouvoir;
}
