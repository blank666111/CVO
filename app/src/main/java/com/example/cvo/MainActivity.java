package com.example.cvo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button button2;
    private Button button3;


    private FirebaseAuth mAuth;
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button2  =  (Button)findViewById(R.id.button2);
        Button button3  =  (Button)findViewById(R.id.button3);
        mAuth = FirebaseAuth.getInstance();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrationActivity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    public void registrationActivity(){
        Intent register = new Intent(this, registration.class);
        startActivity(register);

    }
    public void login(){
        Intent login = new Intent(this, login.class);
        startActivity(login);

    }
}