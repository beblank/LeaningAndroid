package com.ganteng.botak.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    private static final String TWITCH_API = "vfpywe7ol46tzy6ps15lyv5br6rb4w";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);

        Call<Twitch> call = twitchAPI.getTopGames(TWITCH_API);

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                for (Top top:gameList){
                    Log.i("dodol", top.getGame().getName());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });

        twitchAPI.getTopGamesObservable(TWITCH_API)
                .flatMap(flatMapTwitchTop)
                .flatMap(flatMapTwitchGameName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(printAction, logOnError, logOnComplete);

        twitchAPI.getTopGamesObservable(TWITCH_API)
                .flatMap(flatMapTwitchTop)
                .flatMap(flatMapTwitchGameName)
                .filter(filterGameName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(printActionWithFilter, logOnError, logOnComplete);

    }

    Func1<Twitch, Observable<Top>> flatMapTwitchTop = new Func1<Twitch, Observable<Top>>() {
        @Override
        public Observable<Top> call(Twitch twitch) {
            return Observable.from(twitch.getTop());
        }
    };

    Func1<Top, Observable<String>> flatMapTwitchGameName = new Func1<Top, Observable<String>>() {
        @Override
        public Observable<String> call(Top top) {
            return Observable.just(top.getGame().getName());
        }
    };

    Func1<String, Boolean> filterGameName = new Func1<String, Boolean>() {
        @Override
        public Boolean call(String s) {
            return s.startsWith("H");
        }
    };

    Action1<String> printActionWithFilter = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("From rx java with filter " + s);
        }
    };

    Action1<String> printAction = new Action1<String>() {
        @Override
        public void call(String s) {
            System.out.println("From rx java" + s);
        }
    };

    Action1<Throwable> logOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            Log.e("Dodol", "call: " + throwable.getMessage());
        }
    };

    Action0 logOnComplete = new Action0() {
        @Override
        public void call() {
            Log.d("dodol", "call: complete action");
        }
    };

}
