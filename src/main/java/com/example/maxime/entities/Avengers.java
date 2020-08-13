package com.example.maxime.entities;

import com.example.maxime.models.QuatreColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "AVENGERS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "DESCRIPTION")),
        @AttributeOverride(name = "colonne2", column = @Column(name = "ACTEUR")),
})
public class Avengers extends QuatreColonnes {

}
