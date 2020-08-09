package com.example.maxime.modelsdto;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class QuatreColonnesDto {

    Long id;

    String nom;

    String image;

    String colonne1;

    String colonne2;
}
