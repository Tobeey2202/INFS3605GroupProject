package com.example.infs3605groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView signUp;
    private EditText emailField, passwordField;
    private Button login;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(this);

        login = findViewById(R.id.loginButton);
        login.setOnClickListener(this);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);

        progressBar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUp:
                startActivity(new Intent(this,SignUpActivity.class));
                break;

            case R.id.loginButton:
                userLogin();
                break;
        }
    }

    // Present error messages if required, authenticate user login
    private void userLogin(){
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if (email.isEmpty()) {
            emailField.setError("Email required");
            emailField.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailField.setError("Please enter a valid email");
            emailField.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordField.setError("Password required");
            passwordField.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this,"Failed to login - please check credentials",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

}