package com.example.fragappfromscratchrevisted;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fragappfromscratchrevisted.model.ZodiacList;
import com.example.fragappfromscratchrevisted.network.ZodiacService;
import com.example.fragappfromscratchrevisted.network.RetrofitSingleton;

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
//
//        retrofit = RetrofitSingleton.getInstance();
//        ZodiacService planetService = retrofit.create(ZodiacService.class);
//        Call<ZodiacList> planetListCall = planetService.getZodiacListObservable();
//        planetListCall.enqueue(new Callback<ZodiacList>() {
//            @Override
//            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
//                Log.d(TAG, "planet: " + response.body().getPlanetsList().get(0).getName());
//
//            }
//
//            @Override
//            public void onFailure(Call<ZodiacList> call, Throwable t) {
//                Log.d(TAG, "error: " + t.getMessage());
//
//            }
//        });

        retrofit = RetrofitSingleton.getInstance()
                .create(ZodiacService.class)
                .getZodiacListObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZodiacList>() {
                    @Override
                    public void accept(ZodiacList zodiacList) throws Exception {
                        Log.d(TAG, "zodiac: " + zodiacList.getPlanetsList().get(0).getName());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "error: " + throwable.getMessage());
                    }
                });
    }
}
