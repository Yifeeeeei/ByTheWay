# Firebase usage

## Packages

com.firebase.geofire.GeoFire

com.firebase.geofire.GeoLocation

com.firebase.geofire.GeoQuery

com.firebase.geofire.GeoQueryEventListener

com.google.firebase.auth.FirebaseAuth

com.google.firebase.auth.FirebaseAuth

com.google.firebase.database.DataSnapshot

com.google.firebase.database.DatabaseError

com.google.firebase.database.DatabaseReference

com.google.firebase.database.FireDatabase

com.google.firebase.database.ValueEventListener

com.google.firebase.storage.StorageReference

com.google.firebase.storage.UploadTask

## Usage

```
FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
```

```
FirebaseDatabase.getInstance().getReference().child("ride_info").orderByChild("customerId").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()).limitToLast(1).addListenerForSingleValueEvent
```

```
FirebaseAuth.getInstance()
```

```
FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(userID);
```

```
FirebaseAuth.getInstance()
```

```
FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(userID);
```

```
FirebaseStorage.getInstance().getReference().child("profile_images").child(userID);
```

```
FirebaseAuth.getInstance().getCurrentUser().getUid();
```

```
FirebaseDatabase.getInstance().getReference().child("Users").child(accountType).child(user_id).updateChildren(newUserMap).addOnCompleteListener((OnCompleteListener<Void>) task -> {
    Intent intent = new Intent(DetailsActivity.this, LauncherActivity.class);
    startActivity(intent);
    finish();
});
```

```
FirebaseAuth mAuth = FirebaseAuth.getInstance();
```

```
FirebaseAuth.getInstance().getCurrentUser().getUid();
```

```
FirebaseAuth.getInstance().getCurrentUser().getUid();
```

```
FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers").child(userID);
```

```
FirebaseAuth.getInstance().sendPasswordResetEmail(mEmail.getText().toString())
        .addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Snackbar.make(view.findViewById(R.id.layout), "Email Sent", Snackbar.LENGTH_LONG).show();
            } else
                Snackbar.make(view.findViewById(R.id.layout), "Something went wrong", Snackbar.LENGTH_LONG).show();
        });
```

```
FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), task -> {
    if (!task.isSuccessful()) {
        Snackbar.make(view.findViewById(R.id.layout), "sign in error", Snackbar.LENGTH_SHORT).show();
    }
});
```

```
firebaseAuth = FirebaseAuth.getInstance();
```

```
firebaseAuthWithGoogle(credential);
```

```
firebaseAuth.signInWithCredential(credential)
        .addOnCompleteListener(getActivity(), task -> {
            if (task.isSuccessful()) {
                Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
            } else {
                task.getException().printStackTrace();
                Toast.makeText(getActivity(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }

        });
```

```
FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), task -> {
    if(!task.isSuccessful()){
        Snackbar.make(view.findViewById(R.id.layout), "sign up error", Snackbar.LENGTH_SHORT).show();
    }
```

```
FirebaseDatabase.getInstance().getReference("driversWorking");
```

```
DatabaseReference refWorking = FirebaseDatabase.getInstance().getReference("driversWorking")
```