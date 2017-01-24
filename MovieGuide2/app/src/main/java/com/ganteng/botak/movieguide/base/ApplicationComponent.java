package com.ganteng.botak.movieguide.base;

import com.ganteng.botak.movieguide.list.MovieListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityahadiwijaya on 1/24/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MovieListActivity target);

}
