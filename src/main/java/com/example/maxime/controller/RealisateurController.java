package com.example.maxime.controller;

import com.example.maxime.dto.RealisateurDto;
import com.example.maxime.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

    @Autowired
    RealisateurService realisateurService;

    @GetMapping
    public Collection<RealisateurDto> getAllReal() {
        return realisateurService.getAllReal();
    }
}
