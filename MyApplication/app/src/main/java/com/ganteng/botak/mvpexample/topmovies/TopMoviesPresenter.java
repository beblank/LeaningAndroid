package com.ganteng.botak.mvpexample.topmovies;

import android.util.Log;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public class TopMoviesPresenter implements TopMoviesActivityMVP.Presenter {

    private static final String TAG = "dodol";

    private TopMoviesActivityMVP.View view;
    private Subscription subscription=null;
    private TopMoviesActivityMVP.Model model;

    public TopMoviesPresenter(TopMoviesActivityMVP.Model model){
        this.model = model;
    }

    @Override
    public void loadData() {
        subscription = model.result()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(logOnNextLoadData, logOnErrorLoadData, logOnCompleteLoadData);
    }

    Action1<ViewModel> logOnNextLoadData = new Action1<ViewModel>() {
        @Override
        public void call(ViewModel viewModel) {
            if (view != null){
                view.updateData(viewModel);
            }
        }
    };

    Action1<Throwable> logOnErrorLoadData = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            throwable.printStackTrace();
            if (view != null){
                view.showSnackbar("Error getting movies");
            }
        }
    };

    Action0 logOnCompleteLoadData = new Action0() {
        @Override
        public void call() {
            Log.i(TAG, "call: complete");
        }
    };

    @Override
    public void rxUnsubscribe() {
        if (subscription != null){
            if (!subscription.isUnsubscribed()){
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void setView(TopMoviesActivityMVP.View view) {
        this.view = view;
    }
}
