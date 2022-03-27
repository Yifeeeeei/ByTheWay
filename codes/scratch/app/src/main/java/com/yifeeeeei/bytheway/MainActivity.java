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
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // create record
//        ParseObject object = new ParseObject("ExampleObject");
//        object.put("name","zhu bing");
//        object.put("age","20");
//
//        object.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if(e == null){
//                    Log.d("Parse","save successfully");
//                }else{
//                    Log.d("Parse", "save unsuccessfully! " + e.toString());
//                }
//            }
//        });
        ParseUser user = new ParseUser();
        user.setUsername("cyf");
        user.setPassword("my pass");
        user.setEmail("cyf@ple.com");

// other fields can be set just like with ParseObject
        user.put("phone", "650-253-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    ParseUser parseUser = ParseUser.getCurrentUser();
                    Log.d("username",parseUser.getUsername());
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    Log.d("err","something went wrong");
                    Log.d("err",e.toString());
                }
            }
        });

    }
}