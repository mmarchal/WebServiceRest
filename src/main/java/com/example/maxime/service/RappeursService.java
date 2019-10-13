package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.RappeursDto;
import com.example.maxime.entities.Rappeurs;
import com.example.maxime.repository.RappeursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RappeursService {

    @Autowired
    private RappeursRepository rappeursRepository;

    @Autowired
    private GenericConverter<Rappeurs, RappeursDto> genericConverter;

    public Collection<RappeursDto> getRappeurs() {
        return genericConverter.entitiesToDtos(rappeursRepository.findAll(), RappeursDto.class);
    }
}
