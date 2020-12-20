package com.example.maxime.entities;

import com.example.maxime.models.SixColonnes;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "FILMS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "COLONNE1")),
        @AttributeOverride(name = "colonne2", column = @Column(name = "ACTEUR2")),
        @AttributeOverride(name = "colonne3", column = @Column(name = "ANNEE")),
        @AttributeOverride(name = "colonne4", column = @Column(name = "SYNOPSIS", length = 1023)),
})
public class Films  extends SixColonnes {
}
