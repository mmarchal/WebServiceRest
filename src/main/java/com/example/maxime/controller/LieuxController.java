package com.example.maxime.controller;

import com.example.maxime.dto.LieuxDto;
import com.example.maxime.service.LieuxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/lieux")
public class LieuxController {

    @Autowired
    LieuxService lieuxService;

    public Collection<LieuxDto> getAllLocations() { return lieuxService.getAll(); };
}
