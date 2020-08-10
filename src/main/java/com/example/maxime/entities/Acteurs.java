package com.example.maxime.entities;

import com.example.maxime.models.QuatreColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ACTEURS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "FILM1")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "FILM2")),
})
public class Acteurs extends QuatreColonnes {

}
