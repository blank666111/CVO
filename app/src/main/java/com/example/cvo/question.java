package com.example.cvo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import   java.text.SimpleDateFormat;
import java.util.TimeZone;

public class question extends AppCompatActivity  {
    private Switch switch1, switch2, switch3, switch4, switch5, switch6;
    private Button button;
    SimpleDateFormat formatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        long currentTime = System.currentTimeMillis();
        initView();
        database();
    }
    private void initView() {
        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);
        switch5 = (Switch) findViewById(R.id.switch5);
        switch6 = (Switch) findViewById(R.id.switch6);
        button = (Button) findViewById(R.id.button);
    }
    private void database() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Q1, Q2, Q3, Q4, Q5, Q6;
                if (switch1.isChecked())
                    Q1 = switch1.getTextOn().toString();
                else
                    Q1 = switch1.getTextOff().toString();
                if (switch2.isChecked())
                    Q2 = switch2.getTextOn().toString();
                else
                    Q2 = switch2.getTextOff().toString();
                if (switch3.isChecked())
                    Q3 = switch3.getTextOn().toString();
                else
                    Q3 = switch3.getTextOff().toString();
                if (switch4.isChecked())
                    Q4 = switch4.getTextOn().toString();
                else
                    Q4 = switch4.getTextOff().toString();
                if (switch5.isChecked())
                    Q5 = switch5.getTextOn().toString();
                else
                    Q5 = switch5.getTextOff().toString();
                if (switch6.isChecked())
                    Q6 = switch6.getTextOn().toString();
                else
                    Q6 = switch6.getTextOff().toString();


                SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                formatter.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                Date curDate = new Date(System.currentTimeMillis());
                String createDate = formatter.format(curDate);




                //Toast.makeText(getApplicationContext(), "switch1 :" + Q1 + "\n" + "Switch2 :" + Q2+ "\n" + "Switch3 :" + Q3+ "\n" + "Switch4 :" + Q4+ "\n" + "Switch5 :" + Q5+ "\n" + "Switch6 :" + Q6, Toast.LENGTH_LONG);
                String str = "Do you have cough? "+Q1+"\n"+"Do you  lose smell or tast?"+Q2+"\n"+"Do you have Shortness of breath?"+Q3+"\n"+"Do you have fever?"+Q4+"\n"+"Do you have Sore throat?"+Q5+"\n"+"Do you have runny nose?"+Q6;
                if (TextUtils.isEmpty(str)) {
                    return;
                }

                //为实时数据库存值
                myRef.child("user").child(createDate).setValue(str);

                ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get Post object and use the values to update the UI

                        // ..
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // Getting Post failed, log a message

                    }
                };





                Intent note1 = new Intent(question.this, ReadNote.class);
                startActivity(note1);

            }
        });



    }


}
