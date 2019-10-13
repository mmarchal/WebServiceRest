package com.example.maxime.controller;

import com.example.maxime.dto.RappeursDto;
import com.example.maxime.service.RappeursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/rappeurs")
public class RappeursController {

    @Autowired
    private RappeursService rappeursService;

    @GetMapping
    public Collection<RappeursDto> getAllRappeurs() {
        return rappeursService.getRappeurs();
    }
}
