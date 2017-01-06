package com.ganteng.botak.mvpexample.topmovies;

import com.ganteng.botak.mvpexample.http.apimodel.Result;

import rx.Observable;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();

}
