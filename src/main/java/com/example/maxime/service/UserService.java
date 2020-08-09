package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.UserDto;
import com.example.maxime.entities.Acteurs;
import com.example.maxime.entities.Sports;
import com.example.maxime.entities.User;
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

    public void synchro() throws IOException {

        Map<String, Resource> hm  = new HashMap<String, Resource>() {{
            put("acteurs", new ClassPathResource("fichiersSynchro/acteurs.csv"));
            put("actrises", new ClassPathResource("fichiersSynchro/actrises.csv"));
            put("avengers", new ClassPathResource("fichiersSynchro/avengers.csv"));
            put("chansons", new ClassPathResource("fichiersSynchro/chansons.csv"));
            put("dessinsanimes", new ClassPathResource("fichiersSynchro/dessinsanimes.csv"));
            put("films", new ClassPathResource("fichiersSynchro/films.csv"));
            put("horreurs", new ClassPathResource("fichiersSynchro/horreurs.csv"));
            put("jeux", new ClassPathResource("fichiersSynchro/jeux.csv"));
            put("mechants", new ClassPathResource("fichiersSynchro/mechants.csv"));
            put("rappeurs", new ClassPathResource("fichiersSynchro/rappeurs.csv"));
            put("realisateurs", new ClassPathResource("fichiersSynchro/realisateurs.csv"));
            put("sagas", new ClassPathResource("fichiersSynchro/sagas.csv"));
            put("seriesanimes", new ClassPathResource("fichiersSynchro/seriesanimes.csv"));
            put("series", new ClassPathResource("fichiersSynchro/series.csv"));
            put("sports", new ClassPathResource("fichiersSynchro/sports.csv"));
            put("superheros", new ClassPathResource("fichiersSynchro/superheros.csv"));
        }};

        for(Map.Entry<String, Resource> entry : hm.entrySet()) {
            this.lectureData(entry.getKey(), entry.getValue());
        }

        Resource resource = new ClassPathResource("fichiersSynchro/acteurs.csv");

        File file = resource.getFile();

        ArrayList<Acteurs> listeBDD = new ArrayList<>();


        try {

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
                    acteur.setFilm1(film1);
                    acteur.setFilm2(film2);

                    listeBDD.add(acteur);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        listeBDD.forEach((e) -> {
            System.out.println("ENREGISTREMENT DE L'ACTEUR " + e.getNom() + " EN COURS !");
            try {
                acteursRepository.save(e);
                System.out.println("ENREGISTREMENT DE L'ACTEUR " + e.getNom() + " OK !");
            } catch (Exception e1) {
                System.out.println("ERREUR DANS L'ENREGISTREMENT DE L'ACTEUR " + e.getNom() + " : " + e1.getMessage());
            }
        });

    }

    private void lectureData(String key, Resource value) throws IOException {

        File file = value.getFile();
        
        try {

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
                    acteur.setFilm1(film1);
                    acteur.setFilm2(film2);

                    listeBDD.add(acteur);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
