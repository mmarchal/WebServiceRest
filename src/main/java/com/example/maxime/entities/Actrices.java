package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ACTRICES")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "FILM1")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "FILM2")),
})
public class Actrices {

}
