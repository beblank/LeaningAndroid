package com.ganteng.botak.mvpexample.http;

import com.ganteng.botak.mvpexample.http.apimodel.TopRated;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public interface MovieApiService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);
}
