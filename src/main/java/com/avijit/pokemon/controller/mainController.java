package com.avijit.pokemon.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.avijit.pokemon.model.PokemonDetails;

@Component
public class mainController {

    private final RestTemplate restTemplate;

    public mainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonDetails getPokemonDetails(String pokemonName) {
        // Make API request to fetch Pokémon details
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName.toLowerCase();
        return restTemplate.getForObject(apiUrl, PokemonDetails.class);
    }
}
