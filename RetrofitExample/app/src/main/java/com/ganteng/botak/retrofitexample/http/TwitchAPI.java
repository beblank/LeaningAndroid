package com.ganteng.botak.retrofitexample.http;

import com.ganteng.botak.retrofitexample.http.apimodel.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by adityahadiwijaya on 12/30/16.
 */

public interface TwitchAPI {

    @GET("games/top")
    Call<Twitch> getTopGames(@Header("Client-Id")String clientID);

    @GET("games/top")
    Observable<Twitch> getTopGamesObservable(@Header("Client-Id") String clientId);
}
