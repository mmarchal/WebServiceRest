package com.example.maxime.entities;

import com.example.maxime.models.CinqColonnes;
import com.example.maxime.models.SixColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "DESSINSANIMES")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "ANNEE")),
        @AttributeOverride(name = "colonne2", column = @Column(name = "GENTIL")),
        @AttributeOverride(name = "colonne3", column = @Column(name = "MECHANT")),
})
public class DessinsAnimes extends CinqColonnes {

}
