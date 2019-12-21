package com.example.fragappfromscratchrevisted.model;

import java.io.Serializable;

public class Planet implements Serializable {

    private String name;
    private int number;
    private String image;

    public Planet() {
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}
