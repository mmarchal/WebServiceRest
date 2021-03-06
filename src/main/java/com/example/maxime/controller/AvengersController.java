package com.example.maxime.controller;

import com.example.maxime.dto.AvengersDto;
import com.example.maxime.service.AvengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/avengers")
public class AvengersController {

    @Autowired
    AvengersService avengersService;

    @GetMapping
    public Collection<AvengersDto> getAllAvengers() { return avengersService.getAll(); };
}
