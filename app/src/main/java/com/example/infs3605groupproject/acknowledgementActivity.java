package com.example.infs3605groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class acknowledgementActivity extends AppCompatActivity {
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgement);

        closeButton = findViewById(R.id.closeButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {clickedClosePage();}
        });
    }

    public void clickedClosePage(){
        Intent intent = new Intent(acknowledgementActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
