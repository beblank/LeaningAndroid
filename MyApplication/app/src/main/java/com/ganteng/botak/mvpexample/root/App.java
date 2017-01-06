package com.ganteng.botak.mvpexample.root;

import android.app.Application;

import com.ganteng.botak.mvpexample.http.ApiModuleForInfo;
import com.ganteng.botak.mvpexample.http.ApiModuleForName;
import com.ganteng.botak.mvpexample.topmovies.TopMoviesModule;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */



public class App extends Application{

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForName(new ApiModuleForName())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
