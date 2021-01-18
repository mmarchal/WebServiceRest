package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.DisneyDto;
import com.example.maxime.entities.Disney;
import com.example.maxime.repository.DisneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DisneyService {

    @Autowired
    private DisneyRepository disneyRepository;

    @Autowired
    private GenericConverter<Disney, DisneyDto> genericConverter;

    public Collection<DisneyDto> getDisney() {
        return genericConverter.entitiesToDtos(disneyRepository.findAll(), DisneyDto.class);
    }
}
