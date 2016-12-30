package com.ganteng.botak.retrofitexample.root;

import com.ganteng.botak.retrofitexample.MainActivity;
import com.ganteng.botak.retrofitexample.http.APIModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by adityahadiwijaya on 12/30/16.
 */


@Singleton
@Component(modules = {ApplicationModule.class, APIModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
