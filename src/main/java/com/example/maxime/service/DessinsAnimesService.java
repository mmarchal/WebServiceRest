package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.DessinsAnimesDto;
import com.example.maxime.entities.DessinsAnimes;
import com.example.maxime.repository.DessinsAnimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DessinsAnimesService {

    @Autowired
    private DessinsAnimesRepository dessinsAnimesRepository;

    @Autowired
    private GenericConverter<DessinsAnimes, DessinsAnimesDto> genericConverter;

    public Collection<DessinsAnimesDto> getAllDessins() {
        return genericConverter.entitiesToDtos(dessinsAnimesRepository.findAll(), DessinsAnimesDto.class);
    }
}
