package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.JeuxDto;
import com.example.maxime.dto.RappeursDto;
import com.example.maxime.dto.SportsDto;
import com.example.maxime.dto.UserDto;
import com.example.maxime.entities.Acteurs;
import com.example.maxime.entities.Jeux;
import com.example.maxime.entities.Sports;
import com.example.maxime.entities.User;
import com.example.maxime.repository.JeuxRepository;
import com.example.maxime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    GenericConverter<User, UserDto> userConverter;

    @Autowired
    JeuxRepository jeuxRepository;

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
            /*put("acteurs", new ClassPathResource("fichiersSynchro/acteurs.csv"));
            put("actrices", new ClassPathResource("fichiersSynchro/actrices.csv"));
            put("avengers", new ClassPathResource("fichiersSynchro/avengers.csv"));
            put("chansons", new ClassPathResource("fichiersSynchro/chansons.csv"));
            put("dessinsanimes", new ClassPathResource("fichiersSynchro/dessinsanimes.csv"));
            put("films", new ClassPathResource("fichiersSynchro/films.csv"));
            put("horreurs", new ClassPathResource("fichiersSynchro/horreurs.csv"));*/
            put("jeux", new ClassPathResource("fichiersSynchro/jeux.csv"));
            /*put("mechants", new ClassPathResource("fichiersSynchro/mechants.csv"));
            put("rappeurs", new ClassPathResource("fichiersSynchro/rappeurs.csv"));
            put("realisateurs", new ClassPathResource("fichiersSynchro/realisateurs.csv"));
            put("sagas", new ClassPathResource("fichiersSynchro/sagas.csv"));
            put("seriesanimes", new ClassPathResource("fichiersSynchro/seriesanimes.csv"));
            put("series", new ClassPathResource("fichiersSynchro/series.csv"));
            put("sports", new ClassPathResource("fichiersSynchro/sports.csv"));
            put("superheros", new ClassPathResource("fichiersSynchro/superheros.csv"));*/
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
            } else if ("chansons|mechants|superheros".matches(nom)) {
                this.insertThreeDatas(file);
            } else if ("acteurs|actrices|avengers|sagas|series|seriesanimes".matches(nom)) {
                this.insertFourDatas(file);
            } else if ("dessinsanimes|realisateurs".matches(nom)) {
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

    private void insertFourDatas(File file) {
    }

    private void insertThreeDatas(File file) {
    }

    private void insertTwoDatas(File file) {

        try {

            Scanner myReader = new Scanner(file);

            System.out.println(myReader.hasNextLine());

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                List<String> list = Arrays.asList(data.split(";"));

                if(!list.get(0).matches("Nom")) {
                    if(file.getName().contains("jeux")) {

                        Jeux jeu = new Jeux();
                        jeu.setNom(list.get(0));

                        if(list.get(1).isEmpty() || list.get(1).equals("")) {
                            String image = (list.get(0).toLowerCase().replace(" ", "")) + ".png";
                            jeu.setImage(image);
                        } else {
                            jeu.setImage(list.get(1));
                        }

                        jeuxRepository.save(jeu);

                    } else if (file.getName().contains("rappeurs")) {



                    } else {



                    }
                }

                /*if(list.get(0).matches("Nom")) {

                    String nom = listeActeurs.get(0);
                    int longueur = listeActeurs.get(0).split(" ").length;
                    String image = listeActeurs.get(0).split(" ")[longueur-2].toLowerCase() + listeActeurs.get(0).split(" ")[longueur-1].toLowerCase();
                    String film1 = listeActeurs.get(1);
                    String film2 = listeActeurs.get(2);

                }*/

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private void lectureData(String key, Resource value) throws IOException {

        /*try {

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                List<String> listeActeurs = Arrays.asList(data.split(";"));


                if(listeActeurs.size()==3 && !listeActeurs.get(0).matches("Nom")) {

                    String nom = listeActeurs.get(0);
                    int longueur = listeActeurs.get(0).split(" ").length;
                    String image = listeActeurs.get(0).split(" ")[longueur-2].toLowerCase() + listeActeurs.get(0).split(" ")[longueur-1].toLowerCase();
                    String film1 = listeActeurs.get(1);
                    String film2 = listeActeurs.get(2);

                    Acteurs acteur = new Acteurs();
                    acteur.setNom(nom);
                    acteur.setImage("acteurs/" + image + ".png");
                    /*acteur.setFilm1(film1);
                    acteur.setFilm2(film2);

                    listeBDD.add(acteur);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
