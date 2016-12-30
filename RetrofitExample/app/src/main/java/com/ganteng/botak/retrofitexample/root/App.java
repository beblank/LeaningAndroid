package com.ganteng.botak.retrofitexample.root;

import android.app.Application;

import com.ganteng.botak.retrofitexample.http.APIModule;

/**
 * Created by adityahadiwijaya on 12/30/16.
 */

public class App extends Application{

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .aPIModule(new APIModule())
                .build();


    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
