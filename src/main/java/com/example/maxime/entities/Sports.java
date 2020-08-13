package com.example.maxime.entities;

import com.example.maxime.models.DeuxColonnes;
import com.example.maxime.models.TroisColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SPORTS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
})
public class Sports extends DeuxColonnes {

}
