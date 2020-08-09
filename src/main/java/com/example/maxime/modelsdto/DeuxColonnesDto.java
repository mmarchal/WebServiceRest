package com.example.maxime.modelsdto;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class DeuxColonnesDto {

    Long id;

    String nom;

    String image;
}
