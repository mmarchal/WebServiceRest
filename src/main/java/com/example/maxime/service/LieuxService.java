package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.LieuxDto;
import com.example.maxime.entities.Lieux;
import com.example.maxime.repository.LieuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LieuxService {

    @Autowired
    LieuxRepository lieuxRepository;

    @Autowired
    GenericConverter<Lieux, LieuxDto> genericConverter;

    public Collection<LieuxDto> getAll() {
      return genericConverter.entitiesToDtos(lieuxRepository.findAll(), LieuxDto.class);
    };
}
