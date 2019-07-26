package com.example.maxime.controller;

import com.example.maxime.dto.FilmsDto;
import com.example.maxime.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @GetMapping
    public Collection<FilmsDto> getAllSongs() {
        return filmsService.getAllMovies();
    }
}
