package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.ChansonDto;
import com.example.maxime.entities.Chansons;
import com.example.maxime.repository.ChansonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ChansonsService {

    @Autowired
    ChansonsRepository chansonsRepository;

    @Autowired
    GenericConverter<Chansons, ChansonDto> userConverter;

    public Collection<ChansonDto> getAll() {
        return userConverter.entitiesToDtos(this.chansonsRepository.findAll(), ChansonDto.class);
    }
}
