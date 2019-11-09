package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.ActricesDto;
import com.example.maxime.entities.Actrices;
import com.example.maxime.repository.ActricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ActricesService {

    @Autowired
    ActricesRepository actricesRepository;

    @Autowired
    GenericConverter<Actrices, ActricesDto> genericConverter;

    public Collection<ActricesDto> getActrices() {
        return genericConverter.entitiesToDtos(actricesRepository.findAll(), ActricesDto.class);
    }

}
