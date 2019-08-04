package com.example.maxime.controller;

import com.example.maxime.dto.DessinsAnimesDto;
import com.example.maxime.service.DessinsAnimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dessinsanimes")
public class DessinsAnimesController {

    @Autowired
    private DessinsAnimesService dessinsAnimesService;

    @GetMapping
    public Collection<DessinsAnimesDto> getAllEnnemies() { return dessinsAnimesService.getAllDessins(); };

}
