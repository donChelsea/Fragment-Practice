package com.example.fragappfromscratchrevisted.network;

import com.example.fragappfromscratchrevisted.model.ZodiacList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ZodiacService {

    @GET("JDVila/storybook/master/zodiac.json")
    Observable<ZodiacList> getZodiacListObservable();
}