package com.adit.di101.root;

import com.adit.di101.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adit on 1/1/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject (MainActivity activity);

}
