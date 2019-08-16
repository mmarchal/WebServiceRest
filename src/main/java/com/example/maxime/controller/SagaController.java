package com.example.maxime.controller;

import com.example.maxime.dto.SagaDto;
import com.example.maxime.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/saga")
public class SagaController {

    @Autowired
    private SagaService sagaService;

    @GetMapping
    public Collection<SagaDto> getAllSagas() {
        return sagaService.getSagas();
    }
}
