package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.AvengersDto;
import com.example.maxime.entities.Avengers;
import com.example.maxime.repository.AvengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AvengersService {

    @Autowired
    AvengersRepository avengersRepository;

    @Autowired
    GenericConverter<Avengers, AvengersDto> genericConverter;

    public Collection<AvengersDto> getAll() {
      return genericConverter.entitiesToDtos(avengersRepository.findAll(), AvengersDto.class);
    }
}
