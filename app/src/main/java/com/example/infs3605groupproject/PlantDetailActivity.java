package com.example.infs3605groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.Trail;

import java.util.ArrayList;

public class PlantDetailActivity extends AppCompatActivity {
    private TextView plantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        //Fetch the key from the QR Code
        Intent intent = getIntent();
        String value = intent.getStringExtra("QRCode");

        ArrayList<Plant> plantList =Trail.generatePlantList();

        Plant selectedPlant = new Plant();
        for(Plant p : plantList){
            if(p.getPlantId().equals(value)){
                selectedPlant = p;
                break;
            }
        }

        plantName = findViewById(R.id.txtPlantName);
        plantName.setText(selectedPlant.getPlantNameScientific());

        String id = "ich_bin_ein";

        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(id,
                "raw", getPackageName()));
        mediaPlayer.start();



    }
}