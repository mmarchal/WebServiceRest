package com.example.maxime.controller;

import com.example.maxime.dto.SuperHerosDto;
import com.example.maxime.service.SuperHerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/superheros")
public class SuperHerosController {

    @Autowired
    private SuperHerosService superHerosService;

    @GetMapping
    public Collection<SuperHerosDto> getAllSongs() {
        return superHerosService.getSuperHeros();
    }

}
