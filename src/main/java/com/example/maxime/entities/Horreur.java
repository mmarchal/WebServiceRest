package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "HORREUR")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "acteur1", column = @Column(name = "ACTEUR1")),
        @AttributeOverride(name = "acteur2", column = @Column(name = "ACTEUR2")),
        @AttributeOverride(name = "annee", column = @Column(name = "ANNEE")),
        @AttributeOverride(name = "synopsis", column = @Column(name = "SYNOPSIS", length = 1023)),
})
public class Horreur extends ModeleF {
}
