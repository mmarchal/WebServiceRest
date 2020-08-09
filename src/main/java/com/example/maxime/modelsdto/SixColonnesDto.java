package com.example.maxime.modelsdto;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class SixColonnesDto {

    Long id;

    String nom;

    String image;

    String colonne1;

    String colonne2;

    String colonne3;

    String colonne4;

}
