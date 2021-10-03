package com.example.cvo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {

    private Button logout;
    private Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        logout = (Button) findViewById(R.id.logout);
        button6= (Button) findViewById(R.id.button6);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MainPage.this, MainActivity.class);
                startActivity(logout);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent note1 = new Intent(MainPage.this, ReadNote.class);
                startActivity(note1);
            }
        });
    }
}


