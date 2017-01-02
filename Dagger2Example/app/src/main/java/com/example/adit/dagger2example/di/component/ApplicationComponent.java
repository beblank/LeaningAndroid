package com.example.adit.dagger2example.di.component;

import android.app.Application;
import android.content.Context;

import com.example.adit.dagger2example.data.DBHelper;
import com.example.adit.dagger2example.data.DataManager;
import com.example.adit.dagger2example.data.SharedPrefsHelper;
import com.example.adit.dagger2example.di.ApplicationContext;
import com.example.adit.dagger2example.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adit on 1/2/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(Application app);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DBHelper getDbHelper();
}
