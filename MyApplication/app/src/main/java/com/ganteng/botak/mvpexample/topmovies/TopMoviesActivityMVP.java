package com.ganteng.botak.mvpexample.topmovies;

import rx.Observable;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */

public interface TopMoviesActivityMVP {

    interface View {
        void updateData(ViewModel viewModel);
        void showSnackbar(String s);
    }

    interface Presenter{
        void loadData();
        void rxUnsubscribe();
        void setView(TopMoviesActivityMVP.View view);
    }

    interface Model{
        Observable<ViewModel> result();
    }

}
