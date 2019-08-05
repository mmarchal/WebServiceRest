package com.example.maxime.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SERIES")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
        @AttributeOverride(name = "anneeDebut", column = @Column(name = "ANNEEDEBUT")),
        @AttributeOverride(name = "anneeFin", column = @Column(name = "ANNEEFIN")),
})
public class Series extends ModeleS {
}
