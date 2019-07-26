package com.example.maxime.controller;

import com.example.maxime.dto.ActeursDto;
import com.example.maxime.service.ActeursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/acteurs")
public class ActeursController {

    @Autowired
    ActeursService acteursService;

    @GetMapping
    public Collection<ActeursDto> getAllActors() { return acteursService.getActors(); }
}
