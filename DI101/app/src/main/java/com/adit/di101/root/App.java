package com.adit.di101.root;

import android.app.Application;

/**
 * Created by adit on 1/1/2017.
 */

public class App extends Application {
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
