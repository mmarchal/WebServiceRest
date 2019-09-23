package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.SuperHerosDto;
import com.example.maxime.entities.SuperHeros;
import com.example.maxime.repository.SuperHerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SuperHerosService {

    @Autowired
    private SuperHerosRepository superHerosRepository;

    @Autowired
    private GenericConverter<SuperHeros, SuperHerosDto> genericConverter;

    public Collection<SuperHerosDto> getSuperHeros() {
        return genericConverter.entitiesToDtos(superHerosRepository.findAll(), SuperHerosDto.class);
    }
}
