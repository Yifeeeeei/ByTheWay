package com.simcoder.uber.Login;

import android.content.Intent;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
import com.parse.Parse;
import com.parse.ParseUser;
import com.simcoder.uber.R;

import java.io.Serializable;

/**
 * This Activity controls the display of auth fragments of the app:
 * -MenuFragment
 * -LoginFragment
 * -RegisterFragment
 * <p>
 * It is also responsible for taking the user to the main activity if the login or register process is successful
 */
public class AuthenticationActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    MenuFragment menuFragment = new MenuFragment();
    public ParseUser parseUser = null;
    public static MutableLiveData<ParseUser> listen =new MutableLiveData<>();


//    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        //Listens for changes in the auth state
//        firebaseAuthListener = firebaseAuth -> {
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            if (user != null) {
//                Intent intent = new Intent(AuthenticationActivity.this, LauncherActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        };
//        MutableLiveData<ParseUser> listen = new MutableLiveData<>();

        listen.setValue(null); //Initilize with a value

        listen.observe(AuthenticationActivity.this,new Observer<ParseUser>() {
            @Override
            public void onChanged(ParseUser parseUser) {
                if(listen.getValue() != null){
                    Log.d("noticed new user",listen.getValue().getUsername());
//                    Intent intent = new Intent(AuthenticationActivity.this, LauncherActivity.class);
//                startActivity(intent);
//                finish();

                }

            }

//            @Override
//            public void onChanged(String changedValue) {
//                //Do something with the changed value
//            }
        });

        fm.beginTransaction()
                .replace(R.id.container, menuFragment, "StartFragment")
                .addToBackStack(null)
                .commit();
//        Bundle bundle=new Bundle();
//        bundle.putSerializable("userListener", (Serializable) listen);
//        fg1.setArguments(bundle);
    }

    /**
     * Displays the RegisterFragment
     */
    public void registrationClick() {
        fm.beginTransaction()
                .replace(R.id.container, new RegisterFragment(), "RegisterFragment")
                .addToBackStack(null)
                .commit();
    }

    /**
     * Displays the LoginFragment
     */
    public void loginClick() {
        fm.beginTransaction()
                .replace(R.id.container, new LoginFragment(), "RegisterFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        FirebaseAuth.getInstance().addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        FirebaseAuth.getInstance().removeAuthStateListener(firebaseAuthListener);
    }
}
