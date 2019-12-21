package com.example.fragappfromscratchrevisted.network;

import com.example.fragappfromscratchrevisted.model.PlanetList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PlanetService {

    @GET("JDVila/storybook/master/planets.json")
    Observable<PlanetList> getPlanetListObservable();
}
