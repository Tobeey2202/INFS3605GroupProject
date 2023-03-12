package com.example.infs3605groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.infs3605groupproject.objects.Plant;
import com.example.infs3605groupproject.objects.Trail;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlantDetailActivity extends AppCompatActivity{
    private TextView plantName;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    boolean wasPlaying = false;
    private Button btnPlay;
    private Handler myHandler = new Handler();
    private ImageButton homeButton;
    private ImageButton mapButton;
    private ImageButton codeButton;
    private ImageButton profileButton;
    private ImageButton settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        homeButton = findViewById(R.id.detailHomeButton);

        mapButton = findViewById(R.id.detailMapButton);

        codeButton = findViewById(R.id.detailCodeButton);

        profileButton = findViewById(R.id.detailProfileButton);

        settingsButton = findViewById(R.id.detailSettingsButton);

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

        seekBar = findViewById(R.id.audioSeekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                //seekBarHint.setVisibility(View.VISIBLE);
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {
                //seekBarHint.setVisibility(View.VISIBLE);
                int x = (int) Math.ceil(progress / 1000f);

                if (x != 0 && mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    clearMediaPlayer();
                    //fab.setImageDrawable(ContextCompat.getDrawable(PlantDetailActivity.this, android.R.drawable.ic_media_play));
                    PlantDetailActivity.this.seekBar.setProgress(0);
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }
        });

        playSong();
        System.out.println("herro");

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

    public void playSong() {

        try {
            myHandler.postDelayed(UpdateSongTime,100);

            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                clearMediaPlayer();
                seekBar.setProgress(0);
                wasPlaying = true;


            }

            if (!wasPlaying) {

                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }
                String id = "ich_bin_ein";

                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(id,
                        "raw", getPackageName()));


//                mediaPlayer.prepare();
//                mediaPlayer.setVolume(0.5f, 0.5f);
                mediaPlayer.setLooping(false);
                seekBar.setMax(mediaPlayer.getDuration());

                mediaPlayer.start();

            }

            wasPlaying = false;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            double startTime = mediaPlayer.getCurrentPosition();
            seekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);

            }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearMediaPlayer();
    }

    private void clearMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
