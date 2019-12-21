package com.example.fragappfromscratchrevisted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fragappfromscratchrevisted.model.Planet;
import com.example.fragappfromscratchrevisted.model.PlanetList;
import com.example.fragappfromscratchrevisted.network.PlanetService;
import com.example.fragappfromscratchrevisted.network.RetrofitSingleton;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main activity";
    Disposable retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = RetrofitSingleton.getInstance()
                .create(PlanetService.class)
                .getPlanetListObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PlanetList>() {
                    @Override
                    public void accept(PlanetList planetList) throws Exception {
                        List<Planet> planets = planetList.getPlanetsList();


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "error: " + throwable.getMessage());
                    }
                });
    }
}
