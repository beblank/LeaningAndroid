package com.ganteng.botak.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ganteng.botak.retrofitexample.R;
import com.ganteng.botak.retrofitexample.http.TwitchAPI;
import com.ganteng.botak.retrofitexample.http.apimodel.Top;
import com.ganteng.botak.retrofitexample.http.apimodel.Twitch;
import com.ganteng.botak.retrofitexample.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        Call<Twitch> call = twitchAPI.getTopGames("vfpywe7ol46tzy6ps15lyv5br6rb4w");

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                for (Top top:gameList){
                    System.out.print((top.getGame().getName()));
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
