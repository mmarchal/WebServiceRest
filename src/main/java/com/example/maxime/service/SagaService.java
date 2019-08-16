package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.SagaDto;
import com.example.maxime.entities.Saga;
import com.example.maxime.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SagaService {

    @Autowired
    private SagaRepository sagaRepository;

    @Autowired
    private GenericConverter<Saga, SagaDto> genericConverter;

    public Collection<SagaDto> getSagas() {
        return genericConverter.entitiesToDtos(sagaRepository.findAll(), SagaDto.class);
    }
}
