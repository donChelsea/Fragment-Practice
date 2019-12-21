package com.example.fragappfromscratchrevisted;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragappfromscratchrevisted.model.Planet;

import static com.example.fragappfromscratchrevisted.view.PlanetViewHolder.PLANET_INSTANCE;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        BlankFragment fragment = BlankFragment.newInstance();
    }
}
