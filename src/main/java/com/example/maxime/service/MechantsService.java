package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.MechantsDto;
import com.example.maxime.entities.Mechants;
import com.example.maxime.repository.MechantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MechantsService {

    @Autowired
    MechantsRepository mechantsRepository;

    @Autowired
    GenericConverter<Mechants, MechantsDto> genericConverter;

    public Collection<MechantsDto> getEnnemies() {
        return genericConverter.entitiesToDtos(this.mechantsRepository.findAll(), MechantsDto.class);
    }
}
