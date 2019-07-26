package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.JeuxDto;
import com.example.maxime.entities.Jeux;
import com.example.maxime.repository.JeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JeuxServices {

    @Autowired
    JeuxRepository jeuxRepository;

    @Autowired
    GenericConverter<Jeux, JeuxDto> userConverter;

    public Collection<JeuxDto> getAll() {
        return userConverter.entitiesToDtos(jeuxRepository.findAll(), JeuxDto.class);
    }
}
