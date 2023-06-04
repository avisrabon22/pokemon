package com.avijit.pokemon.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class PokemonData {
    @Getter
    private String name;

    @SerializedName("base_experience")
    @Getter
    private int baseExperience;
    @Getter
    private int height;
    @Getter
    private int weight;

    @SerializedName("is_default")
    @Getter
    private boolean isDefault;

    @SerializedName("abilities")
    @Getter
    private List<Ability> abilities;

    // public String getName() {
    // return name;
    // }

    // public int getBaseExperience() {
    // return baseExperience;
    // }

    // public int getHeight() {
    // return height;
    // }

    // public int getWeight() {
    // return weight;
    // }

    // public boolean isDefault() {
    // return isDefault;
    // }

    // public List<Ability> getAbilities() {
    // return abilities;
    // }
}
