package com.example.maxime.controller;

import com.example.maxime.dto.MechantsDto;
import com.example.maxime.service.MechantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mechants")
public class MechantsController {

    @Autowired
    MechantsService mechantsService;

    @GetMapping
    public Collection<MechantsDto> getAllEnnemies() { return mechantsService.getEnnemies(); };

}
