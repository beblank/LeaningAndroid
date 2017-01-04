package com.ganteng.botak.mvpexample.root;

import android.app.Application;

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
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
