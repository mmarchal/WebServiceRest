package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.SportsDto;
import com.example.maxime.entities.Sports;
import com.example.maxime.repository.SportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SportsService {

    @Autowired
    SportsRepository sportsRepository;

    @Autowired
    GenericConverter<Sports, SportsDto> userConverter;

    public Collection<SportsDto> getAllSports() {
        return userConverter.entitiesToDtos(this.sportsRepository.findAll(), SportsDto.class);
    }
}
