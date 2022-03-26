package com.yifeeeeei.bytheway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // create record
        ParseObject object = new ParseObject("ExampleObject");
        object.put("name","zhu bing");
        object.put("age","20");

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Log.d("Parse","save successfully");
                }else{
                    Log.d("Parse", "save unsuccessfully! " + e.toString());
                }
            }
        });
    }
}