package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    private Button logoutButton;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    private TextView name,email;
    private ImageView badge1,badge2,badge3,badge4,badge5,badge6,badge7,badge8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logoutButton = findViewById(R.id.logoutButton);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        badge1 = findViewById(R.id.badge1);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this,gso);

        // Retrieving user information from firebase database
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        try{

            userRef.child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    name.setText(String.valueOf(task.getResult().getValue()));
                }
            });

            userRef.child("email").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    email.setText(String.valueOf(task.getResult().getValue()));
                }
            });

        } catch (Exception e) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT);
        }

        userRef.child("badge1").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Boolean badge1status = (Boolean) task.getResult().getValue();
                if (badge1status==true) {
                    String uri = "drawable/badge1";
                    int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                    Drawable image = getResources().getDrawable(imageResource);
                    badge1.setImageDrawable(image);
                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        SharedPreferences preferences = getSharedPreferences("rememberBoxChecked",MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("remember","");
                        editor.apply();

                        startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
                        finish();
                    }
                });
            }
        });
    }

}