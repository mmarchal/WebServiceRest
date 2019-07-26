package com.example.maxime.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    Long id;

    String nom;

    String prenom;

    String email;

    LocalDate dateNaissance;

    String adresse;

    String password;
}
