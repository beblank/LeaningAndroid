package com.example.adit.dagger2example.data;

import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by adit on 1/2/2017.
 */
@Singleton
public class SharedPrefsHelper {

    public static String PREF_KEY_ACCESS_TOKEN = "access-token";

    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefsHelper(SharedPreferences sharedPreferences){
        mSharedPreferences = sharedPreferences;
    }

    public void put(String key, float value){
        mSharedPreferences.edit().putFloat(key, value).apply();;
    }

    public void put(String key, boolean value){
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void put(String key, int value){
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public Integer get(String key, int defaultValue){
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public  float get(String key, float defaultValue){
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue){
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public void deleteSavedData(String key){
        mSharedPreferences.edit().remove(key).apply();
    }


}
