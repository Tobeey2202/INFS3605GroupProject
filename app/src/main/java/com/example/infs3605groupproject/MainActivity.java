package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.Trail;
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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView welcomeMsg, plantNameTv, quoteTv;
    private ImageView plantImageView;
    private Button infoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeMsg = findViewById(R.id.welcomeMsg);
        plantNameTv = findViewById(R.id.plantNameTv);
        quoteTv = findViewById(R.id.quoteTv);
        plantImageView = findViewById(R.id.plantImageView);
        infoButton = findViewById(R.id.infoButton);


        //Adding a try catch for testing purposes so the main page can be loaded without having a user logged in
        try{
            // Retrieving user information from firebase database
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

            userRef.child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    welcomeMsg.setText("Hi " + String.valueOf(task.getResult().getValue()) + "!");
                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT);
        }

        ArrayList<Plant> plantList = Trail.generatePlantList();
        Random random = new Random();
        Plant plantOfDay = new Plant();
        for (int i = 0; i < plantList.size(); i++) {
            int index = random.nextInt(plantList.size());
            plantOfDay = plantList.get(index);
        }

        plantNameTv.setText(plantOfDay.getPlantNameRegular());
        String uri = "drawable/" + plantOfDay.getImagePath();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable image = getResources().getDrawable(imageResource);
        plantImageView.setImageDrawable(image);

        ArrayList<String> quoteList = Trail.generateQuoteList();
        String quoteOfDay = "";
        for (int i = 0; i < quoteList.size(); i++) {
            int index = random.nextInt(quoteList.size());
            quoteOfDay = quoteList.get(index);
        }
        quoteTv.setText(quoteOfDay);

        Plant finalPlantOfDay = plantOfDay;
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlantDetailActivity.class);
                intent.putExtra("plantID", finalPlantOfDay.getPlantId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }



}