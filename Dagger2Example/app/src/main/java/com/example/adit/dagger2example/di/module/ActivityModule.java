package com.example.adit.dagger2example.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.adit.dagger2example.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adit on 1/2/2017.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }

}
