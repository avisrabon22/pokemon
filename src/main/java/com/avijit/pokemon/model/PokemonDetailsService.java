package com.avijit.pokemon.model;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.avijit.pokemon.controller.mainController;

@Service
public class PokemonDetailsService {
    private final mainController pokemonAPIClient;

    public PokemonDetailsService(mainController pokemonAPIClient) {
        this.pokemonAPIClient = pokemonAPIClient;
    }

    @Cacheable(cacheNames = "pokemonDetailsCache", key = "#pokemonName", sync = true)
    public PokemonDetails getPokemonDetails(String pokemonName) {
        return pokemonAPIClient.getPokemonDetails(pokemonName);
    }
}
