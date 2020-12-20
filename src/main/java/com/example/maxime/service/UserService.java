package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.JeuxDto;
import com.example.maxime.dto.RappeursDto;
import com.example.maxime.dto.SportsDto;
import com.example.maxime.dto.UserDto;
import com.example.maxime.entities.*;
import com.example.maxime.models.*;
import com.example.maxime.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    GenericConverter<User, UserDto> userConverter;

    @Autowired
    JeuxRepository jeuxRepository;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ActeursRepository acteursRepository;
    @Autowired
    ActricesRepository actricesRepository;
    @Autowired
    AvengersRepository avengersRepository;
    @Autowired
    SagaRepository sagaRepository;
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    SeriesAnimesRepository seriesAnimesRepository;
    @Autowired
    RappeursRepository rappeursRepository;
    @Autowired
    MechantsRepository mechantsRepository;
    @Autowired
    SportsRepository sportsRepository;
    @Autowired
    FilmsRepository filmsRepository;
    @Autowired
    RealisateurRepository realisateurRepository;
    @Autowired
    DessinsAnimesRepository dessinsAnimesRepository;
    @Autowired
    ChansonsRepository chansonsRepository;
    @Autowired
    SuperHerosRepository superHerosRepository;
    @Autowired
    HorreurRepository horreurRepository;

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

    public void synchro() throws MalformedURLException {

        String basiqueURL = "http://maxdonnees.alwaysdata.net/datafiles/";

        Map<String, URL> hm  = new HashMap<String, URL>() {{
            put("acteurs", new URL(basiqueURL + "acteurs.csv"));
            put("actrices", new URL(basiqueURL + "actrices.csv"));
            put("avengers", new URL(basiqueURL + "avengers.csv"));
            //put("chansons", new URL(basiqueURL + "chansons.csv"));
            put("dessinsanimes", new URL(basiqueURL + "dessinsanimes.csv"));
            put("films", new URL(basiqueURL + "films.csv"));
            put("horreurs", new URL(basiqueURL + "horreur.csv"));
            put("jeux", new URL(basiqueURL + "jeux.csv"));
            put("mechants", new URL(basiqueURL + "mechants.csv"));
            put("rappeurs", new URL(basiqueURL + "rappeurs.csv"));
            put("realisateurs", new URL(basiqueURL + "realisateurs.csv"));
            put("sagas", new URL(basiqueURL + "saga.csv"));
            put("seriesanimes", new URL(basiqueURL + "seriesanimes.csv"));
            //put("series", new URL(basiqueURL + "series.csv"));
            put("sports", new URL(basiqueURL + "sports.csv"));
            //put("superheros", new URL(basiqueURL + "superheros.csv"));
        }};

        for(Map.Entry<String, URL> entry : hm.entrySet()) {

            String nom = entry.getKey();
            File file = new File("");
            try {
                FileUtils.copyURLToFile(entry.getValue(), file);
            } catch (Exception e1) {
                System.out.println(e1.getMessage());
            }


            if(nom.matches("jeux|rappeurs|sports")) {
                this.insertTwoDatas(entry.getValue());
            } else if (nom.matches("chansons|mechants|superheros")) {
                this.insertThreeDatas(entry.getValue());
            } else if (nom.matches("acteurs|actrices|avengers|sagas|series|seriesanimes")) {
                this.insertFourDatas(entry.getValue());
            } else if (nom.matches("dessinsanimes|realisateurs")) {
                this.insertFiveDatas(entry.getValue());
            } else {
                this.insertSixDatas(entry.getValue());
            }

        }
    }

    private void test(URL url) {

        Scanner scnr = null;

        try {
            scnr = new Scanner(url.openStream());
            while(scnr.hasNextLine()){
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if(!liste[0].equals("ID")) {
                    if (url.getPath().contains("acteurs")) {

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

                    else if (url.getPath().contains("actrices")) {

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

                    else if (url.getPath().contains("avengers")) {
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

                    else if (url.getPath().contains("saga")) {

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

                            logger.info(String.valueOf(liste[4].length()));

                            saga.setColonne1(liste[3].trim());
                            saga.setColonne2(liste[4].trim());

                            sagaRepository.save(saga);

                        } else {
                            logger.log(Level.INFO, "SAGA TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }

                    else if (url.getPath().matches("series")) {

                        Optional<Series> isExiste = seriesRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {

                            Series serie = new Series();
                            serie.setId(Long.parseLong(liste[0]));

                            serie.setNom(liste[1]);

                            try {
                                serie.setImage(liste[2]);
                            } catch (Exception e) {
                                serie.setImage(null);
                            }

                            logger.info(String.valueOf(liste[4].length()));

                            serie.setColonne1(liste[3].trim());
                            serie.setColonne2(liste[4].trim());

                            seriesRepository.save(serie);

                        } else {
                            logger.log(Level.INFO, "SERIE TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }

                    else if (url.getPath().equals("seriesanimes.csv")){

                        Optional<SeriesAnimes> isExiste = seriesAnimesRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {

                            SeriesAnimes serieAnime = new SeriesAnimes();
                            serieAnime.setId(Long.parseLong(liste[0]));

                            serieAnime.setNom(liste[1]);

                            try {
                                serieAnime.setImage(liste[2]);
                            } catch (Exception e) {
                                serieAnime.setImage(null);
                            }

                            serieAnime.setColonne1(liste[3].trim());
                            serieAnime.setColonne2(liste[4].trim());

                            seriesAnimesRepository.save(serieAnime);

                        } else {
                            logger.log(Level.INFO, "SERIE ANIME TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //FILMS HORREURS
    private void insertSixDatas(URL url) {

        try (Scanner scnr = new Scanner(url.openStream())) {
            while (scnr.hasNextLine()) {
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if (!liste[0].equals("ID")) {
                    if (url.getPath().contains("films")) {

                        Optional<Films> isExiste = filmsRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Films film = new Films();
                            film.setId(Long.parseLong(liste[0]));
                            film.setNom(liste[1]);

                            try {
                                film.setImage(liste[2]);
                            } catch (Exception e) {
                                film.setImage(null);
                            }

                            film.setColonne1(liste[3]);
                            film.setColonne2(liste[4]);
                            film.setColonne3(liste[5]);
                            film.setColonne4(liste[6]);

                            filmsRepository.save(film);
                        } else {
                            logger.log(Level.INFO, "FILM TROUVE " + isExiste.map(SixColonnes::getNom));
                        }

                    } else if (url.getPath().contains("horreur")) {

                        Optional<Horreur> isExiste = horreurRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Horreur horreur = new Horreur();
                            horreur.setId(Long.parseLong(liste[0]));
                            horreur.setNom(liste[1]);

                            try {
                                horreur.setImage(liste[2]);
                            } catch (Exception e) {
                                horreur.setImage(null);
                            }

                            horreur.setColonne1(liste[3]);
                            horreur.setColonne2(liste[4]);
                            horreur.setColonne3(liste[5]);
                            horreur.setColonne4(liste[6]);

                            horreurRepository.save(horreur);
                        } else {
                            logger.log(Level.INFO, "HORREUR TROUVE " + isExiste.map(SixColonnes::getNom));
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //dessins animes realisateurs
    private void insertFiveDatas(URL url) {

        try (Scanner scnr = new Scanner(url.openStream())) {
            while (scnr.hasNextLine()) {
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if (!liste[0].equals("ID")) {
                    if (url.getPath().contains("realisateurs")) {

                        Optional<Realisateur> isExiste = realisateurRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Realisateur realisateur = new Realisateur();
                            realisateur.setId(Long.parseLong(liste[0]));
                            realisateur.setNom(liste[1]);

                            try {
                                realisateur.setImage(liste[2]);
                            } catch (Exception e) {
                                realisateur.setImage(null);
                            }

                            realisateur.setColonne1(liste[3]);
                            if (liste.length>=5) {
                                realisateur.setColonne2(liste[4]);
                            } else {
                                realisateur.setColonne2("");
                            }
                            if (liste.length>=6) {
                                realisateur.setColonne3(liste[5]);
                            } else {
                                realisateur.setColonne3("");
                            }

                            realisateurRepository.save(realisateur);
                        } else {
                            logger.log(Level.INFO, "REALISATEUR TROUVE " + isExiste.map(CinqColonnes::getNom));
                        }

                    } else if (url.getPath().contains("dessinsanimes")) {

                        Optional<DessinsAnimes> isExiste = dessinsAnimesRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            DessinsAnimes dessinsAnimes = new DessinsAnimes();
                            dessinsAnimes.setId(Long.parseLong(liste[0]));
                            dessinsAnimes.setNom(liste[1]);

                            try {
                                dessinsAnimes.setImage(liste[2]);
                            } catch (Exception e) {
                                dessinsAnimes.setImage(null);
                            }
                            dessinsAnimes.setColonne1(liste[3]);
                            if (liste.length>=5) {
                                dessinsAnimes.setColonne2(liste[4]);
                            } else {
                                dessinsAnimes.setColonne2("");
                            }
                            if (liste.length>=6) {
                                dessinsAnimes.setColonne3(liste[5]);
                            } else {
                                dessinsAnimes.setColonne3("");
                            }

                            dessinsAnimesRepository.save(dessinsAnimes);
                        } else {
                            logger.log(Level.INFO, "DESSIN ANIME TROUVE " + isExiste.map(CinqColonnes::getNom));
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //acteurs actrices avengers sagas series seriesanimes
    private void insertFourDatas(URL url) {

        try (Scanner scnr = new Scanner(url.openStream())) {
            while (scnr.hasNextLine()) {
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if (!liste[0].equals("ID")) {
                    if (url.getPath().contains("acteurs")) {

                        Optional<Acteurs> isExiste = acteursRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {
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

                    } else if (url.getPath().contains("actrices")) {

                        Optional<Actrices> isExiste = actricesRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {
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

                    } else if (url.getPath().contains("avengers")) {
                        Optional<Avengers> isExiste = avengersRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {
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

                    } else if (url.getPath().contains("saga")) {

                        Optional<Saga> isExiste = sagaRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {
                            Saga saga = new Saga();
                            saga.setId(Long.parseLong(liste[0]));
                            saga.setNom(liste[1]);

                            try {
                                saga.setImage(liste[2]);
                            } catch (Exception e) {
                                saga.setImage(null);
                            }

                            logger.info(String.valueOf(liste[4].length()));

                            saga.setColonne1(liste[3].trim());
                            saga.setColonne2(liste[4].trim());

                            sagaRepository.save(saga);

                        } else {
                            logger.log(Level.INFO, "SAGA TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    } else if (url.getPath().matches("series")) {

                        Optional<Series> isExiste = seriesRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {

                            Series serie = new Series();
                            serie.setId(Long.parseLong(liste[0]));

                            serie.setNom(liste[1]);

                            try {
                                serie.setImage(liste[2]);
                            } catch (Exception e) {
                                serie.setImage(null);
                            }

                            logger.info(String.valueOf(liste[4].length()));

                            serie.setColonne1(liste[3].trim());
                            serie.setColonne2(liste[4].trim());

                            seriesRepository.save(serie);

                        } else {
                            logger.log(Level.INFO, "SERIE TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    } else if (url.getPath().equals("seriesanimes.csv")) {

                        Optional<SeriesAnimes> isExiste = seriesAnimesRepository.findById(Long.parseLong(liste[0]));

                        if (!isExiste.isPresent()) {

                            SeriesAnimes serieAnime = new SeriesAnimes();
                            serieAnime.setId(Long.parseLong(liste[0]));

                            serieAnime.setNom(liste[1]);

                            try {
                                serieAnime.setImage(liste[2]);
                            } catch (Exception e) {
                                serieAnime.setImage(null);
                            }

                            serieAnime.setColonne1(liste[3].trim());
                            serieAnime.setColonne2(liste[4].trim());

                            seriesAnimesRepository.save(serieAnime);

                        } else {
                            logger.log(Level.INFO, "SERIE ANIME TROUVE " + isExiste.map(QuatreColonnes::getNom));
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //chansons mechants superheros
    private void insertThreeDatas(URL url) {

        try (Scanner scnr = new Scanner(url.openStream())) {
            while (scnr.hasNextLine()) {
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if (!liste[0].equals("ID")) {
                    if (url.getPath().contains("chansons")) {

                        Optional<Chansons> isExiste = chansonsRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Chansons chanson = new Chansons();
                            chanson.setId(Long.parseLong(liste[0]));
                            chanson.setNom(liste[1]);

                            try {
                                chanson.setImage(liste[2]);
                            } catch (Exception e) {
                                chanson.setImage(null);
                            }

                            chansonsRepository.save(chanson);
                        } else {
                            logger.log(Level.INFO, "CHANSON TROUVE " + isExiste.map(TroisColonnes::getNom));
                        }

                    } else if (url.getPath().contains("mechants")) {

                        Optional<Mechants> isExiste = mechantsRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Mechants mechant = new Mechants();
                            mechant.setId(Long.parseLong(liste[0]));
                            mechant.setNom(liste[1]);

                            try {
                                mechant.setImage(liste[2]);
                            } catch (Exception e) {
                                mechant.setImage(null);
                            }
                            mechant.setColonne1(liste[3]);

                            mechantsRepository.save(mechant);
                        } else {
                            logger.log(Level.INFO, "MECHANT TROUVE " + isExiste.map(TroisColonnes::getNom));
                        }

                    } else {

                        Optional<SuperHeros> isExiste = superHerosRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            SuperHeros superHeros = new SuperHeros();
                            superHeros.setId(Long.parseLong(liste[0]));
                            superHeros.setNom(liste[1]);

                            try {
                                superHeros.setImage(liste[2]);
                            } catch (Exception e) {
                                superHeros.setImage(null);
                            }
                            superHeros.setColonne1(liste[3]);

                            superHerosRepository.save(superHeros);
                        } else {
                            logger.log(Level.INFO, "SUPER HEROS TROUVE " + isExiste.map(TroisColonnes::getNom));
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //JEUX - RAPPEURS - SPORTS
    private void insertTwoDatas(URL url) {

        try (Scanner scnr = new Scanner(url.openStream())) {
            while (scnr.hasNextLine()) {
                String[] liste = scnr.nextLine().split(cvsSplitBy);

                if (!liste[0].equals("ID")) {
                    if (url.getPath().contains("jeux")) {

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

                    } else if (url.getPath().contains("rappeurs")) {

                        Optional<Rappeurs> isExiste = rappeursRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Rappeurs rappeurs = new Rappeurs();
                            rappeurs.setId(Long.parseLong(liste[0]));
                            rappeurs.setNom(liste[1]);

                            try {
                                rappeurs.setImage(liste[2]);
                            } catch (Exception e) {
                                rappeurs.setImage(null);
                            }

                            rappeursRepository.save(rappeurs);
                        } else {
                            logger.log(Level.INFO, "RAPPEUR TROUVE " + isExiste.map(DeuxColonnes::getNom));
                        }

                    } else {

                        Optional<Sports> isExiste = sportsRepository.findById(Long.parseLong(liste[0]));

                        if(!isExiste.isPresent()) {
                            Sports sport = new Sports();
                            sport.setId(Long.parseLong(liste[0]));
                            sport.setNom(liste[1]);

                            try {
                                sport.setImage(liste[2]);
                            } catch (Exception e) {
                                sport.setImage(null);
                            }

                            sportsRepository.save(sport);
                            logger.log(Level.INFO, "SPORT AJOUTE " + sport.getNom());
                        } else {
                            logger.log(Level.INFO, "SPORT TROUVE " + isExiste.map(DeuxColonnes::getNom));
                        }

                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
