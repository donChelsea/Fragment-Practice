package com.example.fragappfromscratchrevisted.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragappfromscratchrevisted.R;
import com.example.fragappfromscratchrevisted.model.Planet;
import com.example.fragappfromscratchrevisted.view.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
    private List<Planet> planets;

    public PlanetAdapter(List<Planet> planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.planet_item_view, viewGroup, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int i) {
        planetViewHolder.onBind(planets.get(i));
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }
}
