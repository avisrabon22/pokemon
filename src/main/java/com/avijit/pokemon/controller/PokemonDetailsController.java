package com.avijit.pokemon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.avijit.pokemon.model.PokemonDetails;
import com.avijit.pokemon.model.PokemonDetailsService;

@RestController
public class PokemonDetailsController {
    private final PokemonDetailsService pokemonDetailsService;

    public PokemonDetailsController(PokemonDetailsService pokemonDetailsService) {
        this.pokemonDetailsService = pokemonDetailsService;
    }

    @GetMapping("/pokemon/{pokemonName}")
    public PokemonDetails getPokemonDetails(@PathVariable String pokemonName) {
        return pokemonDetailsService.getPokemonDetails(pokemonName);
    }
}
