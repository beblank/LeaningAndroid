package com.ganteng.botak.mvpexample.topmovies;

import com.ganteng.botak.mvpexample.http.ApiModuleForName;
import com.ganteng.botak.mvpexample.http.MoreInfoApiService;
import com.ganteng.botak.mvpexample.http.MovieApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */
@Module(includes = {ApiModuleForName.class})
public class TopMoviesModule {

    @Provides
    public TopMoviesActivityMVP.Presenter provideTopMoviesActivityPresenter(TopMoviesActivityMVP.Model topMoviesModel){
        return new TopMoviesPresenter(topMoviesModel);
    }

    @Provides
    public TopMoviesActivityMVP.Model provideTopMoviesActivityModel(Repository repository){
        return new TopMoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService){
        return new TopMoviesRepository(movieApiService, moreInfoApiService);
    }





}
