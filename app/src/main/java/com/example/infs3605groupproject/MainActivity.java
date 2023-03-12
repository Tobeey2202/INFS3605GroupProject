package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button logoutButton;
    private TextView welcomeMsg;
    private ImageButton homeButton;
    private ImageButton mapButton;
    private ImageButton codeButton;
    private ImageButton profileButton;
    private ImageButton settingsButton;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMsg = findViewById(R.id.welcomeMsg);

        logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(this);

        logoutButton = findViewById(R.id.logoutButton);

        homeButton = findViewById(R.id.homeHomeButton);

        mapButton = findViewById(R.id.homeMapButton);

        codeButton = findViewById(R.id.homeCodeButton);

        profileButton = findViewById(R.id.homeProfileButton);

        settingsButton = findViewById(R.id.homeSettingsButton);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this,gso);

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

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedOnSettingsPage();}
        });

        // Retrieving user information from firebase database
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        userRef.child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                welcomeMsg.setText("Hi " + String.valueOf(task.getResult().getValue()) + "!");
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logoutButton:
                logoutUser();
                break;
        }
    }

    public void clickedOnHomePage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickedOnMapPage(){
        Intent intent = new Intent(this, MapActivity.class);
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

    public void clickedOnSettingsPage(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void logoutUser() {
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
}