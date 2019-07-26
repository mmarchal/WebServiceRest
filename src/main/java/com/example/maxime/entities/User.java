package com.example.maxime.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String nom;

    @Column
    String prenom;

    @Column
    String email;

    @Column
    LocalDate dateNaissance;

    @Column
    String adresse;

    @Column(name = "password")
    private String password;
}
