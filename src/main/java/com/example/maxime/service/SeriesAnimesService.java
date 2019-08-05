package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.SeriesAnimesDto;
import com.example.maxime.entities.SeriesAnimes;
import com.example.maxime.repository.SeriesAnimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SeriesAnimesService {

    @Autowired
    SeriesAnimesRepository seriesAnimesRepository;

    @Autowired
    GenericConverter<SeriesAnimes, SeriesAnimesDto> genericConverter;

    public Collection<SeriesAnimesDto> getAllSeriesAnimes() {
        return genericConverter.entitiesToDtos(seriesAnimesRepository.findAll(), SeriesAnimesDto.class);
    }
}
