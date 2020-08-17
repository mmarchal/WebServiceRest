package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.JeuxDto;
import com.example.maxime.dto.RappeursDto;
import com.example.maxime.dto.SportsDto;
import com.example.maxime.dto.UserDto;
import com.example.maxime.entities.*;
import com.example.maxime.models.DeuxColonnes;
import com.example.maxime.models.QuatreColonnes;
import com.example.maxime.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    GenericConverter<User, UserDto> userConverter;

    @Autowired
    JeuxRepository jeuxRepository;

    @Autowired
    ActeursRepository acteursRepository;
    @Autowired
    ActricesRepository actricesRepository;
    @Autowired
    AvengersRepository avengersRepository;
    @Autowired
    SagaRepository sagaRepository;

    Logger logger = Logger.getLogger("logger");

    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ";";

    @Override
    public UserDetails loadUserByUsername(final String mail) throws UsernameNotFoundException {
        User user = this.userRepo.findByEmail(mail);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password !");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), this.getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public Collection<UserDto> getAll() {
        return userConverter.entitiesToDtos(this.userRepo.findAll(),UserDto.class);
    }

    public boolean createUser(UserDto user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(null);
        this.userRepo.save(this.userConverter.dtoToEntity(user,User.class));
        return true;
    }

    public List databasesNames() {
        return this.userRepo.allNames();
    }

    public void synchro() {

        Map<String, Resource> hm  = new HashMap<String, Resource>() {{
            put("acteurs", new ClassPathResource("fichiersSynchro/acteurs.csv"));
            put("actrices", new ClassPathResource("fichiersSynchro/actrices.csv"));
            put("avengers", new ClassPathResource("fichiersSynchro/avengers.csv"));
            //put("chansons", new ClassPathResource("fichiersSynchro/chansons.csv"));
            //put("dessinsanimes", new ClassPathResource("fichiersSynchro/dessinsanimes.csv"));
            //put("films", new ClassPathResource("fichiersSynchro/films.csv"));
            //put("horreurs", new ClassPathResource("fichiersSynchro/horreurs.csv"));
            put("jeux", new ClassPathResource("fichiersSynchro/jeux.csv"));
            //put("mechants", new ClassPathResource("fichiersSynchro/mechants.csv"));
            //put("rappeurs", new ClassPathResource("fichiersSynchro/rappeurs.csv"));
            //put("realisateurs", new ClassPathResource("fichiersSynchro/realisateurs.csv"));
            put("sagas", new ClassPathResource("fichiersSynchro/saga.csv"));
            //put("seriesanimes", new ClassPathResource("fichiersSynchro/seriesanimes.csv"));
            //put("series", new ClassPathResource("fichiersSynchro/series.csv"));
            //put("sports", new ClassPathResource("fichiersSynchro/sports.csv"));
            //put("superheros", new ClassPathResource("fichiersSynchro/superheros.csv"));
        }};

        for(Map.Entry<String, Resource> entry : hm.entrySet()) {

            String nom = entry.getKey();
            File file = new File("");
            try {
                file = entry.getValue().getFile();
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }

            if(nom.matches("jeux|rappeurs|sports")) {
                this.insertTwoDatas(file);
            } else if (nom.matches("chansons|mechants|superheros")) {
                this.insertThreeDatas(file);
            } else if (nom.matches("acteurs|actrices|avengers|sagas|series|seriesanimes")) {
                this.insertFourDatas(file);
            } else if (nom.matches("dessinsanimes|realisateurs")) {
                this.insertFiveDatas(file);
            } else {
                this.insertSixDatas(file);
            }

        }
    }

    private void insertSixDatas(File file) {
    }

    private void insertFiveDatas(File file) {
    }


    //acteurs actrices avengers sagas series seriesanimes
    private void insertFourDatas(File file) {

        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] liste = line.split(cvsSplitBy);

                if (!liste[1].matches("Nom")) {
                    if (file.getName().contains("acteurs")) {

                        Optional<Acteurs> isExiste = acteursRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Acteurs acteur = new Acteurs();
                            acteur.setId(Long.parseLong(liste[0]));
                            acteur.setNom(liste[1]);

                            try {
                                acteur.setImage(liste[2]);
                            } catch (Exception e) {
                                acteur.setImage(null);
                            }

                            acteur.setColonne1(liste[3].trim());
                            acteur.setColonne2(liste[4].trim());

                            acteursRepository.save(acteur);

                        } else {
                            logger.log(Level.INFO, "ACTEUR TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }

                    else if (file.getName().contains("actrices")) {

                        Optional<Actrices> isExiste = actricesRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Actrices actrice = new Actrices();
                            actrice.setId(Long.parseLong(liste[0]));
                            actrice.setNom(liste[1]);

                            try {
                                actrice.setImage(liste[2]);
                            } catch (Exception e) {
                                actrice.setImage(null);
                            }

                            actrice.setColonne1(liste[3].trim());
                            actrice.setColonne2(liste[4].trim());

                            actricesRepository.save(actrice);

                        } else {
                            logger.log(Level.INFO, "ACTRICE TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }

                    else if (file.getName().contains("avengers")) {
                        Optional<Avengers> isExiste = avengersRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Avengers avenger = new Avengers();
                            avenger.setId(Long.parseLong(liste[0]));
                            avenger.setNom(liste[1]);

                            try {
                                avenger.setImage(liste[2]);
                            } catch (Exception e) {
                                avenger.setImage(null);
                            }

                            avenger.setColonne1(liste[3].trim());
                            avenger.setColonne2(liste[4].trim());

                            avengersRepository.save(avenger);

                        } else {
                            logger.log(Level.INFO, "AVENGER TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }

                    else if (file.getName().contains("saga")) {

                        Optional<Saga> isExiste = sagaRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Saga saga = new Saga();
                            saga.setId(Long.parseLong(liste[0]));
                            saga.setNom(liste[1]);

                            try {
                                saga.setImage(liste[2]);
                            } catch (Exception e) {
                                saga.setImage(null);
                            }

                            saga.setColonne1(liste[3].trim());
                            saga.setColonne2(liste[4].trim());

                            sagaRepository.save(saga);

                        } else {
                            logger.log(Level.INFO, "SAGA TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    } else if (file.getName().contains("series")) {


                    } else {


                    }
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

    private void insertThreeDatas(File file) {
    }

    //JEUX - RAPPEURS - SPORTS
    private void insertTwoDatas(File file) {

        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] liste = line.split(cvsSplitBy);

                if (!liste[1].matches("Nom")) {
                    if (file.getName().contains("jeux")) {

                        Optional<Jeux> isExiste = jeuxRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Jeux jeu = new Jeux();
                            jeu.setId(Long.parseLong(liste[0]));
                            jeu.setNom(liste[1]);

                            try {
                                jeu.setImage(liste[2]);
                            } catch (Exception e) {
                                jeu.setImage(null);
                            }

                            jeuxRepository.save(jeu);
                        } else {
                            logger.log(Level.INFO, "JEU TROUVE " + isExiste.map(DeuxColonnes::getNom));
                        }

                    } else if (file.getName().contains("rappeurs")) {


                    } else {


                    }
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
