package com.avijit.pokemon.model;

import java.util.List;

public class PokemonDetails {
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;

    public static class Ability {
        private AbilityData ability;

        // Constructors, getters, and setters

        public static class AbilityData {
            private String name;

            // Constructors, getters, and setters

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public AbilityData getAbility() {
            return ability;
        }

        public void setAbility(AbilityData ability) {
            this.ability = ability;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
