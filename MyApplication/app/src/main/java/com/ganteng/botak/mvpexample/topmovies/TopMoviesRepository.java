package com.ganteng.botak.mvpexample.topmovies;

import android.util.Log;

import com.ganteng.botak.mvpexample.http.MovieApiService;
import com.ganteng.botak.mvpexample.http.MoreInfoApiService;
import com.ganteng.botak.mvpexample.http.apimodel.OmdbApi;
import com.ganteng.botak.mvpexample.http.apimodel.Result;
import com.ganteng.botak.mvpexample.http.apimodel.TopRated;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public class TopMoviesRepository implements Repository {

    private MovieApiService movieApiService;
    private MoreInfoApiService moreInfoApiService;
    private List<String> countries;
    private List<Result> results;
    private long timestamp;

    private static final long STALE_MS = 20*1000;

    public TopMoviesRepository(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService){
        this.movieApiService = movieApiService;
        this.moreInfoApiService = moreInfoApiService;
        this.timestamp = System.currentTimeMillis();
        countries = new ArrayList<>();
        results = new ArrayList<>();
    }

    public boolean isUpToDate(){
        return System.currentTimeMillis() - timestamp < STALE_MS;
    }

    @Override
    public Observable<Result> getResultsFromMemory() {

        if(isUpToDate()){
            return Observable.from(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Result> getResultFromNetwork() {

        Observable<TopRated> topRatedObservable = movieApiService.getTopRatedMovies(1)
                                                    .concatWith(movieApiService.getTopRatedMovies(2))
                                                    .concatWith(movieApiService.getTopRatedMovies(3));

        return topRatedObservable.concatMap(concatResultFromNetwork)
                .doOnNext(resultActionFromNetwork);
    }

    Func1<TopRated, Observable<Result>> concatResultFromNetwork = new Func1<TopRated, Observable<Result>>() {
        @Override
        public Observable<Result> call(TopRated topRated) {
            return Observable.from(topRated.results);
        }
    };

    Action1<Result> resultActionFromNetwork = new Action1<Result>() {
        @Override
        public void call(Result result) {
            results.add(result);
        }
    };

    @Override
    public Observable<String> getCountriesFromMemory() {
        if (isUpToDate()){
            return Observable.from(countries);
        } else {
            timestamp = System.currentTimeMillis();
            countries.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<String> getCountriesFromNetwork() {
        return getResultFromNetwork().concatMap(concatMapResultOmdbApi)
                .concatMap(concatMapOmdbApiObservable)
                .doOnNext(countriesAction);
    }

    Func1<Result, Observable<OmdbApi>> concatMapResultOmdbApi = new Func1<Result, Observable<OmdbApi>>() {
        @Override
        public Observable<OmdbApi> call(Result result) {
            Log.i("dodol", "call: omdb " + result.title);
            return moreInfoApiService.getCountry(result.title);
        }
    };

    Func1<OmdbApi, Observable<String>> concatMapOmdbApiObservable = new Func1<OmdbApi, Observable<String>>() {
        @Override
        public Observable<String> call(OmdbApi omdbApi) {
            return Observable.just(omdbApi.getCountry());
        }
    };

    Action1<String> countriesAction = new Action1<String>() {
        @Override
        public void call(String s) {
            countries.add(s);
        }
    };


    @Override
    public Observable<String> getCountryData() {
        return getCountriesFromMemory().switchIfEmpty(getCountriesFromMemory());
    }

    @Override
    public Observable<Result> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultFromNetwork());
    }
}
