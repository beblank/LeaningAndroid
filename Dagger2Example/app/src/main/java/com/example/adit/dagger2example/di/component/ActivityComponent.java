package com.example.adit.dagger2example.di.component;

import com.example.adit.dagger2example.MainActivity;
import com.example.adit.dagger2example.di.PerActivity;
import com.example.adit.dagger2example.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by adit on 1/2/2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
