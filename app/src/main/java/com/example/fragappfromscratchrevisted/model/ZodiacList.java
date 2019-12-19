package com.example.fragappfromscratchrevisted.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ZodiacList {
@SerializedName("zodiac")

    private List<Zodiac> planetsList;

    public ZodiacList(List<Zodiac> planetsList) {
        this.planetsList = planetsList;
    }

    public List<Zodiac> getPlanetsList() {
        return planetsList;
    }
}
