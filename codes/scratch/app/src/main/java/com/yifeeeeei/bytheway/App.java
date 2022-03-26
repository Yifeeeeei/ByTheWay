package com.yifeeeeei.bytheway;
import com.parse.Parse;
import android.app.Application;
public class App extends  Application{
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
