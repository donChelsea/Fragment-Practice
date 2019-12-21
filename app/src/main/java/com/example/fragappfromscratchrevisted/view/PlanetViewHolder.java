package com.example.fragappfromscratchrevisted.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.fragappfromscratchrevisted.R;
import com.example.fragappfromscratchrevisted.model.Planet;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    private static final String PLANET_INSTANCE = "planet_instance";
    private TextView planetNameTv;

    public PlanetViewHolder(@NonNull View itemView) {
        super(itemView);

        planetNameTv = itemView.findViewById(R.id.planet_name);
    }

    public void onBind(Planet planet) {
        planetNameTv.setText(planet.getName());
        planetNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(PLANET_INSTANCE, planet);
                v.getContext().startActivity(intent, DisplayActivity.class);
            }
        });
    }
}
