package com.example.maxime.entities;

import com.example.maxime.models.DeuxColonnes;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RAPPEURS")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM")),
        @AttributeOverride(name = "image", column = @Column(name = "IMAGE")),
})
public class Rappeurs extends DeuxColonnes {

}
