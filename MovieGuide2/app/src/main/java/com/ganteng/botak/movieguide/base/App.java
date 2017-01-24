package com.ganteng.botak.movieguide.base;

import android.app.Application;

/**
 * Created by adityahadiwijaya on 1/24/17.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = createAppComponent();
    }

    private ApplicationComponent createAppComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}

