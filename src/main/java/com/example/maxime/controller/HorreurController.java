package com.example.maxime.controller;

import com.example.maxime.dto.HorreurDto;
import com.example.maxime.service.HorreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/horreur")
public class HorreurController {

    @Autowired
    HorreurService horreurService;

    @GetMapping
    public Collection<HorreurDto> getAllHorreurs() {
        return horreurService.getAllHorreursMovies();
    }
}
