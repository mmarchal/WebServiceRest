package com.example.maxime.controller;

import com.example.maxime.dto.ActricesDto;
import com.example.maxime.service.ActricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/actrices")
public class ActricesController {

    @Autowired
    private ActricesService actricesService;

    @GetMapping
    public Collection<ActricesDto> getAllActrices() {
        return actricesService.getActrices();
    }
}