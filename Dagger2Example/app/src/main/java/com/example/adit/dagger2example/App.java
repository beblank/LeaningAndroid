package com.example.adit.dagger2example;

import android.app.Application;
import android.content.Context;

import com.example.adit.dagger2example.data.DataManager;
import com.example.adit.dagger2example.di.component.ApplicationComponent;
import com.example.adit.dagger2example.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by adit on 1/2/2017.
 */

public class App extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static App get(Context context){
        return (App)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
