package com.example.maxime.controller;

import com.example.maxime.dto.JeuxDto;
import com.example.maxime.service.JeuxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/jeuxvideos")
public class JeuxController {

    @Autowired
    JeuxServices jeuxServices;

    @GetMapping
    public Collection<JeuxDto> getAllJeux(){
        return jeuxServices.getAll();
    }
}
