package com.ganteng.botak.mvpexample.root;

import com.ganteng.botak.mvpexample.http.ApiModuleForInfo;
import com.ganteng.botak.mvpexample.http.ApiModuleForName;
import com.ganteng.botak.mvpexample.topmovies.TopMoviesActivity;
import com.ganteng.botak.mvpexample.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class, ApiModuleForInfo.class, TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
