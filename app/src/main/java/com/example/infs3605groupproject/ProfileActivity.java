package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
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
    private ImageButton homeButton;
    private ImageButton mapButton;
    private ImageButton codeButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logoutButton = findViewById(R.id.logoutButton);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this,gso);

        homeButton = findViewById(R.id.profileHomeButton);

        mapButton = findViewById(R.id.profileMapButton);

        codeButton = findViewById(R.id.profileCodeButton);

        profileButton = findViewById(R.id.profileProfileButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnHomePage();}
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnMapPage();}
        });

        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnCodePage();}
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnProfilePage();}
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

    public void clickedOnHomePage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickedOnMapPage(){
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        startActivity(intent);
        System.out.print("map page works");
    }

    public void clickedOnCodePage(){
        Intent intent = new Intent(this, QrScannerActivity.class);
        startActivity(intent);
    }

    public void clickedOnProfilePage(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}