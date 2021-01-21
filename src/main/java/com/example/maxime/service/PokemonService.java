package com.example.maxime.service;

import com.example.maxime.converter.GenericConverter;
import com.example.maxime.dto.PokemonDto;
import com.example.maxime.entities.Pokemon;
import com.example.maxime.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    GenericConverter<Pokemon, PokemonDto> genericConverter;

    public Collection<PokemonDto> getPokemons() {
        return genericConverter.entitiesToDtos(this.pokemonRepository.findAll(), PokemonDto.class);
    }

}
