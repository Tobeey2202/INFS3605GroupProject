package com.example.infs3605groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.Trail;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlantDetailActivity extends AppCompatActivity {
    private TextView plantName, plantNameScientific, locationOnCampus, traditionalUses, geographicLocation, facilitiesInfo;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    boolean wasPlaying = false;
    private Button btnPlay, btnViewOnMap;
    private Handler myHandler = new Handler();
    private ImageView plantDiagram;
    private Plant selectedPlant;
    private ImageView locationOnCampusPhoto;

    public static int oneTimeOnly =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

//        homeButton = findViewById(R.id.detailHomeButton);
//
//        mapButton = findViewById(R.id.detailMapButton);
//
//        codeButton = findViewById(R.id.detailCodeButton);
//
//        profileButton = findViewById(R.id.detailProfileButton);
        btnPlay = findViewById(R.id.btnPlay);
        btnViewOnMap = findViewById(R.id.btnViewPlantOnMap);

        //Fetch the key from the QR Code
        Intent intent = getIntent();
        String value = intent.getStringExtra("QRCode");

        String valueFromRecyclerView = intent.getStringExtra("plantID");

        ArrayList<Plant> plantList = Trail.generatePlantList();

        selectedPlant = new Plant();
        for(Plant p : plantList){
            if(p.getPlantId().equals(value)){
                selectedPlant = p;
                break;
            }

            if(p.getPlantId().equals(valueFromRecyclerView)){
                selectedPlant = p;
                break;
            }
        }

        plantName = findViewById(R.id.regularPlantName);
        plantNameScientific = findViewById(R.id.scientificPlantName);
        locationOnCampus = findViewById(R.id.locationOfPlant);
        traditionalUses = findViewById(R.id.traditionalUses);
        plantDiagram = findViewById(R.id.plantDiagram);
        locationOnCampusPhoto = findViewById(R.id.locationOnCampusPhoto);
        geographicLocation = findViewById(R.id.geographicLocation);
        facilitiesInfo = findViewById(R.id.facilitiesInfo);

        facilitiesInfo.setText(selectedPlant.getFacilitiesInfo());
        geographicLocation.setText(selectedPlant.getGeographicDistribution());
        plantName.setText(selectedPlant.getPlantNameRegular());
        plantNameScientific.setText(selectedPlant.getPlantNameScientific());
        locationOnCampus.setText(selectedPlant.getLocation());
        traditionalUses.setText(selectedPlant.getTraditionalUse());

        String uri = "drawable/" + selectedPlant.getImagePath();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable image = getResources().getDrawable(imageResource);
        plantDiagram.setImageDrawable(image);

        String uri2 = "drawable/" + selectedPlant.getImagePath2();
        int imageResource2 = getResources().getIdentifier(uri2, null, getPackageName());
        Drawable image2 = getResources().getDrawable(imageResource2);
        locationOnCampusPhoto.setImageDrawable(image2);


        seekBar = findViewById(R.id.audioSeekbar);
        prepareMediaPlayer();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                //seekBarHint.setVisibility(View.VISIBLE);
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
                //seekBarHint.setVisibility(View.VISIBLE);
                int x = (int) Math.ceil(progress / 1000f);
                //Show where the user is seeking to
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePlayButton();
            }
        });

        btnViewOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPlantOnMap();
            }
        });
    }

    //Handle View On Map Intent
    private void viewPlantOnMap(){
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        intent.putExtra("plantName", selectedPlant.getPlantNameRegular());
        startActivity(intent);
    }



    public void prepareMediaPlayer() {
            mediaPlayer = new MediaPlayer();
            //Replace next line with actual code to get the plant id for the media file
            String id = "ich_bin_ein";

            mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(id,
                    "raw", getPackageName()));
            mediaPlayer.setLooping(false);
            seekBar.setMax(mediaPlayer.getDuration());
            seekBar.setProgress(0);


    }
    //Method to update seekbar
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            double startTime = mediaPlayer.getCurrentPosition();
            //System.out.println(startTime);
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
            }
    };



    private void handlePlayButton(){
        double finalTime = mediaPlayer.getDuration();

        if (oneTimeOnly == 0) {
            seekBar.setMax((int) finalTime);
            oneTimeOnly = 1;
        }
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnPlay.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_play_arrow_24, 0, 0, 0);
        } else if(mediaPlayer.isPlaying()==false){
            mediaPlayer.start();
            btnPlay.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_pause_24, 0, 0, 0);
            myHandler.postDelayed(UpdateSongTime,100);
        }
    }
}
