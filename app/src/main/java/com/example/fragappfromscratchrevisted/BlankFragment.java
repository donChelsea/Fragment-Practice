package com.example.fragappfromscratchrevisted;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragappfromscratchrevisted.model.Planet;
import com.squareup.picasso.Picasso;

import static com.example.fragappfromscratchrevisted.view.PlanetViewHolder.PLANET_INSTANCE;

public class BlankFragment extends Fragment {
    private String name, image;
    private int number;
    private TextView nameTv, numberTv;
    private ImageView imageIv;

    public BlankFragment() {
    }

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Planet planet = (Planet) getArguments().getSerializable(PLANET_INSTANCE);

            name = getArguments().getString(planet.getName());
            number = getArguments().getInt(String.valueOf(planet.getNumber()));
            image = getArguments().getString(planet.getImage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        nameTv = view.findViewById(R.id.name_tv);
        numberTv = view.findViewById(R.id.number_tv);
        imageIv = view.findViewById(R.id.image_iv);

        nameTv.setText(name);
        numberTv.setText(number);
        Picasso.get().load(image).into(imageIv);

        return view;
    }

}
