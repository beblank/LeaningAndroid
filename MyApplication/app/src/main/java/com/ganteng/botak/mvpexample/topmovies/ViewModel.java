package com.ganteng.botak.mvpexample.topmovies;

/**
 * Created by adityahadiwijaya on 1/4/17.
 */
public class ViewModel {

    public String country;
    public String name;

    public ViewModel(String name, String country){
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
