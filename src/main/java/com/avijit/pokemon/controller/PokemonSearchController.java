package com.avijit.pokemon.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.avijit.pokemon.model.Ability;
import com.avijit.pokemon.model.PokemonData;
import com.google.gson.Gson;

@RestController
public class PokemonSearchController {
    @GetMapping("/pokemon/{name}")
    @Cacheable(value = "cacheName", key = "#name")
    public ResponseEntity<String> searchPokemon(@PathVariable String name) {
        try {
            // Create the URL with the Pokémon name
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + name;

            // Create a RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Send the GET request and receive the response
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            // Return the response with the appropriate HTTP status code
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred during Pokémon search.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/pokemon/{name}/attributes")
    @Cacheable(value = "cacheName", key = "#name")
    public ResponseEntity<String> getInterestingAttributes(@PathVariable String name) {
        try {
            // Create the URL with the Pokémon name
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + name;

            // Create a RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Send the GET request and receive the response
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

            // Extract interesting attributes from the response
            String attributes = extractInterestingAttributes(response.getBody());

            // Return the attributes with the appropriate HTTP status code
            return new ResponseEntity<>(attributes, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error occurred while fetching Pokémon attributes.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String extractInterestingAttributes(String pokemonData) {
        Gson gson = new Gson();
        PokemonData pokemon = gson.fromJson(pokemonData, PokemonData.class);

        StringBuilder attributes = new StringBuilder();
        attributes.append("Name: ").append(pokemon.getName()).append("\n");
        attributes.append("Base Experience: ").append(pokemon.getBaseExperience()).append("\n");
        attributes.append("Height: ").append(pokemon.getHeight()).append("\n");
        attributes.append("Weight: ").append(pokemon.getWeight()).append("\n");
        attributes.append("Is Default: ").append(pokemon.isDefault()).append("\n");

        // Abilities
        attributes.append("Abilities: ").append("\n");
        for (Ability ability : pokemon.getAbilities()) {
            attributes.append("- ").append(ability.getAbilityDetail().getName()).append("\n");
        }

        return attributes.toString();
    }

}
