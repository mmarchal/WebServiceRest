package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.FilmsDto;
import com.example.maxime.entities.Films;
import com.example.maxime.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FilmsService {

    @Autowired
    FilmsRepository filmsRepository;

    @Autowired
    GenericConverter<Films, FilmsDto> userConverter;

    public Collection<FilmsDto> getAllMovies() {
        return userConverter.entitiesToDtos(filmsRepository.findAll(), FilmsDto.class);
    }
}
