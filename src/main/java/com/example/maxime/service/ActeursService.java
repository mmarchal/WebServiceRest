package com.example.maxime.service;

import com.example.maxime.MaximeApplication;
import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.ActeursDto;
import com.example.maxime.entities.Acteurs;
import com.example.maxime.repository.ActeursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class ActeursService {

    @Autowired
    ActeursRepository acteursRepository;

    @Autowired
    GenericConverter<Acteurs, ActeursDto> genericConverter;

    Logger logger = LoggerFactory.getLogger(ActeursService.class);

    public Collection<ActeursDto> getActeurs() {
        return genericConverter.entitiesToDtos(acteursRepository.findAll(), ActeursDto.class);
    }

}
