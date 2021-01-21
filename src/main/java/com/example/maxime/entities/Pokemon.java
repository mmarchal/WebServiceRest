package com.example.maxime.entities;

import com.example.maxime.models.TroisColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "POKEMON")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "colonne1", column = @Column(name = "NUMERO")),
})
public class Pokemon extends TroisColonnes {

}