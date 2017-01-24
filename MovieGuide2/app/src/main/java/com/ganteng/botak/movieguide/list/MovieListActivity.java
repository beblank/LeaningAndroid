package com.ganteng.botak.movieguide.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ganteng.botak.movieguide.R;
import com.ganteng.botak.movieguide.base.App;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ((App)getApplication()).getComponent().inject(this);
    }
}
