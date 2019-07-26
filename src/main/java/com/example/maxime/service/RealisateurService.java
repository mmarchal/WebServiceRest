package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.RealisateurDto;
import com.example.maxime.entities.Realisateur;
import com.example.maxime.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RealisateurService {

    @Autowired
    RealisateurRepository realisateurRepository;

    @Autowired
    GenericConverter<Realisateur, RealisateurDto> userConverter;

    public Collection<RealisateurDto> getAllReal() {
        return userConverter.entitiesToDtos(this.realisateurRepository.findAll(), RealisateurDto.class);
    }

}
