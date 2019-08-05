package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.SeriesDto;
import com.example.maxime.entities.Series;
import com.example.maxime.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    @Autowired
    GenericConverter<Series, SeriesDto> userConverter;

    public Collection<SeriesDto> getAllSeries() {
        return userConverter.entitiesToDtos(this.seriesRepository.findAll(), SeriesDto.class);
    }
}
