package com.ganteng.botak.mvpexample.topmovies;

import android.util.Log;

import com.ganteng.botak.mvpexample.http.apimodel.Result;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public class TopMoviesModel implements TopMoviesActivityMVP.Model{

    private  Repository repository;

    public TopMoviesModel(Repository repository){
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        Log.i("dodol", "result: observable zip ");
        return Observable.zip(repository.getResultData(), repository.getCountryData(), viewModelFunc2);
    }

    Func2<Result, String, ViewModel> viewModelFunc2 = new Func2<Result, String, ViewModel>() {
        @Override
        public ViewModel call(Result result, String s) {
            Log.i("dodol", "call: view model func 2" + result.title);
            return new ViewModel(result.title, s);
        }
    };
}
