package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.ActeursDto;
import com.example.maxime.entities.Acteurs;
import com.example.maxime.repository.ActeursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class ActeursService {

    @Autowired
    ActeursRepository acteursRepository;

    @Autowired
    GenericConverter<Acteurs, ActeursDto> genericConverter;

    Logger logger = LoggerFactory.getLogger(ActeursService.class);

    public Collection<ActeursDto> getActeurs() {
        return genericConverter.entitiesToDtos(acteursRepository.findAll(), ActeursDto.class);
    }

    public void insertData(ActeursDto acteur) {

        Acteurs a = new Acteurs();

        a.setNom(acteur.getNom());
        a.setImage(acteur.getImage());
        a.setFilm1(acteur.getFilm1());
        a.setFilm2(acteur.getFilm2());

        this.acteursRepository.save(a);

    }

    public void synchro() {

        String csvFile = "fichiersSynchros/acteurs.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                List<String> listeActeurs = Arrays.asList(line.split(cvsSplitBy));


                if(listeActeurs.size()==3) {

                    String nom = listeActeurs.get(0);
                    int longueur = listeActeurs.get(0).split(" ").length;
                    String image = listeActeurs.get(0).split(" ")[longueur-2].toLowerCase() + listeActeurs.get(0).split(" ")[longueur-1].toLowerCase();
                    String film1 = listeActeurs.get(1);
                    String fim2 = listeActeurs.get(2);

                    logger.info(image);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
