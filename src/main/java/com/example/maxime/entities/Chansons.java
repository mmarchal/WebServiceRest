package com.example.maxime.entities;

import com.example.maxime.models.TroisColonnes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CHANSONS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "MUSIQUE")),
})
public class Chansons extends TroisColonnes {

}
