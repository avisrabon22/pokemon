package com.avijit.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class Ability {
    @SerializedName("ability")
    private AbilityDetail abilityDetail;

    public AbilityDetail getAbilityDetail() {
        return abilityDetail;
    }
}
