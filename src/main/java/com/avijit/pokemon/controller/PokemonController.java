package com.avijit.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avijit.pokemon.model.PokemonDetails;
import com.avijit.pokemon.model.PokemonDetailsService;

@Controller
public class PokemonController {
    private final PokemonDetailsService pokemonDetailsService;

    public PokemonController(PokemonDetailsService pokemonDetailsService) {
        this.pokemonDetailsService = pokemonDetailsService;
    }

    @GetMapping("/pokemon")
    public String getPokemonDetails(@RequestParam("pokemonName") String pokemonName, Model model) {
        try {
            PokemonDetails pokemonDetails = pokemonDetailsService.getPokemonDetails(pokemonName);
            model.addAttribute("pokemonDetails", pokemonDetails);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Failed to fetch Pokémon details.");
        }

        return "index";
    }
}
