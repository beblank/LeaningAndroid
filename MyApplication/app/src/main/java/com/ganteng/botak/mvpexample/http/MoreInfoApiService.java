package com.ganteng.botak.mvpexample.http;

import com.ganteng.botak.mvpexample.http.apimodel.OmdbApi;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public interface MoreInfoApiService {

    @GET("/")
    Observable <OmdbApi> getCountry(@Query("t") String title);
}
