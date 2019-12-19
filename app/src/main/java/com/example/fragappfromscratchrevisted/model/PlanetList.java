package com.example.fragappfromscratchrevisted.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetList {
@SerializedName("planets")

    private List<Planet> planetsList;

    public PlanetList(List<Planet> planetsList) {
        this.planetsList = planetsList;
    }

    public List<Planet> getPlanetsList() {
        return planetsList;
    }
}
