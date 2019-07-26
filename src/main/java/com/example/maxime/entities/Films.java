package com.example.maxime.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String image;

    @Column
    String acteur1;

    @Column
    String acteur2;

    @Column
    String annee;

    @Column(length = 1023)
    String synopsis;
}
