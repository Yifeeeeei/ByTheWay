package com.simcoder.uber.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
import com.onesignal.OneSignal;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.simcoder.uber.Customer.CustomerMapActivity;
import com.simcoder.uber.Driver.DriverMapActivity;
import com.simcoder.uber.R;
import com.stripe.android.PaymentConfiguration;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * First activity of the app.
 * <p>
 * Responsible for checking if the user is logged in or not and call
 * the AuthenticationActivity or MainActivity depending on that.
 */
public class LauncherActivity extends AppCompatActivity {

    int triedTypes = 0;
    public static MutableLiveData<Boolean> customer_listen_dataChange =new MutableLiveData<>();
    public static void onCustomerDataChanged(){
        customer_listen_dataChange.setValue(!customer_listen_dataChange.getValue());

    }
    public static MutableLiveData<Boolean> driver_listen_dataChange =new MutableLiveData<>();
    public static void onDriverDataChanged(){
        driver_listen_dataChange.setValue(!driver_listen_dataChange.getValue());

    }
    ParseObject customerDatabase = null;
    ParseObject driverDatabase = null;
//current user 就是一个database!!!



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customer_listen_dataChange.setValue(false);
        driver_listen_dataChange.setValue(false);



//        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (ParseUser.getCurrentUser() == null) {
            checkUserAccType();
        } else {
            Intent intent = new Intent(LauncherActivity.this, AuthenticationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }




    }
//    static public Boolean dataChangedFla



    /**
     * Check user account type, either customer or driver.
     * If it doesn't have a type then start the DetailsActivity for the
     * user to be able to pick one.
     */
    private void checkUserAccType() {
        String userID;

//        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userID = ParseUser.getCurrentUser().getObjectId();
        // WARNING
        //get this user's database in Parse



        customer_listen_dataChange.observe(LauncherActivity.this,new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean newB) {
                // 看是骑手还是乘客
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Customers");
                query.whereEqualTo("customerId", userID);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> scoreList, ParseException e) {
                        if (e == null) {
//                            Log.d("score", "Retrieved " + scoreList.size() + " scores");
                            startApis("Customers");
                    Intent intent = new Intent(getApplication(), CustomerMapActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                        } else {
                            checkNoType();
//                            Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });

//                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
//                    startApis("Customers");
//                    Intent intent = new Intent(getApplication(), CustomerMapActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    checkNoType();
//                }


            }

//
        });

//        DatabaseReference mCustomerDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(userID);
//        mCustomerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
//                    startApis("Customers");
//                    Intent intent = new Intent(getApplication(), CustomerMapActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    checkNoType();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NotNull DatabaseError databaseError) {
//            }
//        });
//        DatabaseReference mDriverDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(userID);
//        mDriverDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
//                    startApis("Drivers");
//                    Intent intent = new Intent(getApplication(), DriverMapActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    checkNoType();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NotNull DatabaseError databaseError) {
//            }
//        });

        driver_listen_dataChange.observe(LauncherActivity.this,new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean newB) {
                // 看是骑手还是乘客
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Drivers");
                query.whereEqualTo("driverId", userID);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> scoreList, ParseException e) {
                        if (e == null) {
//                            Log.d("score", "Retrieved " + scoreList.size() + " scores");
                            startApis("Drivers");
                            Intent intent = new Intent(getApplication(), DriverMapActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        } else {
                            checkNoType();
//                            Log.d("score", "Error: " + e.getMessage());
                        }
                    }
                });




            }

//
        });

    }

    /**
     * checks if both types have not been fetched meaning the DetailsActivity must be called
     */
    void checkNoType() {
        triedTypes++;
        if (triedTypes == 2) {
            Intent intent = new Intent(getApplication(), DetailsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }

    /**
     * starts up onesignal and stripe apis
     * @param type - type of the user (customer, driver)
     */
    void startApis(String type) {
        String c_userId = ParseUser.getCurrentUser().getObjectId();
        OneSignal.startInit(this).init();
//        OneSignal.sendTag("User_ID", FirebaseAuth.getInstance().getCurrentUser().getUid());
        OneSignal.sendTag("User_ID", c_userId);
        OneSignal.setEmail(ParseUser.getCurrentUser().getUsername());
        //OneSignal.setInFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification);
        OneSignal.idsAvailable((userId, registrationId) -> {
//            FirebaseDatabase.getInstance().getReference().child("Users").child(type).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("notificationKey").setValue(userId);
            ParseQuery<ParseObject> query = ParseQuery.getQuery(type);
            String id_part = type=="Driver"?"driver":"customer" + "Id";
            query.whereEqualTo(id_part, c_userId);
            query.findInBackground(new FindCallback<ParseObject>() {
                public void done(List<ParseObject>parseObj, ParseException e) {
                    if (e == null) {
                            parseObj.get(0).put("notificationKey",c_userId);
                    } else {

                    }
                }
            });


        });
        PaymentConfiguration.init(
                getApplicationContext(),
                getResources().getString(R.string.publishablekey)
        );
    }
}
