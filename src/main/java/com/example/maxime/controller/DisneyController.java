package com.example.maxime.controller;

import com.example.maxime.dto.DisneyDto;
import com.example.maxime.service.DisneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/disney")
public class DisneyController {

    @Autowired
    private DisneyService disneyService;

    @GetMapping
    public Collection<DisneyDto> getAllDisney() {
        return disneyService.getDisney();
    }
}

