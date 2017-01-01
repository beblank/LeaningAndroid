package com.adit.di101.root;

import android.content.Context;
import android.net.ConnectivityManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by adit on 1/1/2017.
 */
@Module
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context){
        this.context = context;
    }

    @Provides @Singleton
    public Context providesContext(){
        return context;
    }

    @Provides @Singleton
    public ConnectivityManager providesConnectivityManager(Context context){
        return (ConnectivityManager)context.getSystemService(context.CONNECTIVITY_SERVICE);
    }


}
