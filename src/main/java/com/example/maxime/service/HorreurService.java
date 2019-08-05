package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.HorreurDto;
import com.example.maxime.entities.Horreur;
import com.example.maxime.repository.HorreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HorreurService {

    @Autowired
    HorreurRepository horreurRepository;

    @Autowired
    GenericConverter<Horreur, HorreurDto> userConverter;

    public Collection<HorreurDto> getAllHorreursMovies() {
        return userConverter.entitiesToDtos(horreurRepository.findAll(), HorreurDto.class);
    }

}
