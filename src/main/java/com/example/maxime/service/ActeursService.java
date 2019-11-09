package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.ActeursDto;
import com.example.maxime.entities.Acteurs;
import com.example.maxime.repository.ActeursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActeursService {

    @Autowired
    ActeursRepository acteursRepository;

    @Autowired
    GenericConverter<Acteurs, ActeursDto> genericConverter;

    public Collection<ActeursDto> getActeurs() {
        return genericConverter.entitiesToDtos(acteursRepository.findAll(), ActeursDto.class);
    }
}
