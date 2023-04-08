package com.example.infs3605groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class welcomePageActivity extends AppCompatActivity {
//    private Button startButton;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

//        startButton = findViewById(R.id.startButton);

//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {clickedStartButton();}
//        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(welcomePageActivity.this,acknowledgementActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }

    public void clickedStartButton(){
        Intent intent = new Intent(this, acknowledgementActivity.class);
        startActivity(intent);
    }
}
