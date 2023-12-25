package com.sahilshaikh.homeworkoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity {
 Button button1;
 Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);






        button1=findViewById(R.id.startbeginners);
        button2=findViewById(R.id.startadvance);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);



            }
        });



    }


    public void forbeginners(View view) {
        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }

    public void forAdvance(View view) {
        Intent intent= new Intent(MainActivity.this, SecondActivity2.class);
        startActivity(intent);


    }

    public void food(View view) {
        Intent intent= new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);




    }

}