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

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private Button logoutButton;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    private TextView name,email,badgeInfo;
    private ImageView badge1,badge2,badge3,badge4,badge5,badge6,badge7,badge8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logoutButton = findViewById(R.id.logoutButton);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        badge1 = findViewById(R.id.badge1);
        badge2 = findViewById(R.id.badge2);
        badge3 = findViewById(R.id.badge3);
        badge4 = findViewById(R.id.badge4);
        badge5 = findViewById(R.id.badge5);
        badge6 = findViewById(R.id.badge6);
        badge7 = findViewById(R.id.badge7);
        badge8 = findViewById(R.id.badge8);
        badgeInfo = findViewById(R.id.badgeInfo);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc = GoogleSignIn.getClient(this, gso);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            setUpProfile();
        } else if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            badgeInfo.setText("Create an account to collect badges");
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
                }
            });
        }

    }

    public void setUpProfile() {
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

            List<ImageView> badgeList = new ArrayList<>();
            badgeList.add(badge1);
            badgeList.add(badge2);
            badgeList.add(badge3);
            badgeList.add(badge4);
            badgeList.add(badge5);
            badgeList.add(badge6);
            badgeList.add(badge7);
            badgeList.add(badge8);

            for (int i = 1; i < 9; i++) {
                String badgeIndex = Integer.toString(i);
                userRef.child("badge" + i).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        Boolean badgeStatus = (Boolean) task.getResult().getValue();
                        if (badgeStatus==true) {
                            String uri = "drawable/badge" + badgeIndex;
                            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                            Drawable image = getResources().getDrawable(imageResource);
                            badgeList.get(Integer.parseInt(badgeIndex)-1).setImageDrawable(image);
                        }
                    }
                });
            }


        } catch (Exception e) {
            Toast.makeText(this, "Error getting user data", Toast.LENGTH_SHORT);
        }


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
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