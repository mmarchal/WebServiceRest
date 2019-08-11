package com.example.maxime.controller;

import com.example.maxime.dto.SportsDto;
import com.example.maxime.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sports")
public class SportsController {

    @Autowired
    SportsService sportsService;

    @GetMapping
    public Collection<SportsDto> getAllAvengers() { return sportsService.getAllSports(); };
}
