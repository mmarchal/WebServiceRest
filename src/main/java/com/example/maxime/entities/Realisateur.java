package com.example.maxime.entities;

import com.example.maxime.models.CinqColonnes;
import com.example.maxime.models.SixColonnes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "REALISATEUR")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "INFO1")),
        @AttributeOverride(name = "colonne2", column = @Column(name = "INFO2")),
        @AttributeOverride(name = "colonne3", column = @Column(name = "INFO3")),
})
public class Realisateur extends CinqColonnes {

}