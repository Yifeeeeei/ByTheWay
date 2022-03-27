package com.simcoder.uber;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("KSDJFKASJFI3S8DSJFDH")
                // if desired
                .server("http://81.70.251.233:1337/parse/")
                .build()
        );
    }
}
