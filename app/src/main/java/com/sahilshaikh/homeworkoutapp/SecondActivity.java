package com.sahilshaikh.homeworkoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {
    int [] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        newArray=new int[]{
                R.id.boatpose1,R.id.boatpose2,R.id.boatpose3, R.id.boatpose4,R.id.boatpose5,R.id.boatpose6,
                R.id.boatpose7,R.id.boatpose8,R.id.boatpose9, R.id.pose10,R.id.pose11,R.id.pose12, R.id.pose13,R.id.boatpose14,
                R.id.boatpose15,


        };


    }

    public void imagebuttonclicked(View view) {

        for (int i = 0; i < newArray.length ; i++) {
            if(view.getId()==newArray[i])
            {
              int value =i+1;
                Log.i("FIRST",String.valueOf(i));
             Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
             intent.putExtra("value",String.valueOf(value));
             startActivity(intent);
            }
            
        }
    }
}