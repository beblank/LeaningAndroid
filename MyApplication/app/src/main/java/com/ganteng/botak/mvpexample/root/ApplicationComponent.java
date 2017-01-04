package com.ganteng.botak.mvpexample.root;

import com.ganteng.botak.mvpexample.topmovies.TopMoviesActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
