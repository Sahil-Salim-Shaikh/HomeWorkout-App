package com.sahilshaikh.homeworkoutapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity2 extends AppCompatActivity {
    String buttonValue;
    Button startButton;
    private CountDownTimer countDownTimer;
    TextView textView;
    private boolean isTimerRunning;
    private long timeLeftInMillis;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.valueOf(buttonValue);
        int layoutId = 0;
        switch (intValue) {
            case 1:
                layoutId = R.layout.activity_pose1;
                break;
            case 2:
                layoutId = R.layout.activity_pose2;
                break;
            case 3:
                layoutId = R.layout.activity_pose3;
                break;
            case 4:
                layoutId = R.layout.activity_pose4;
                break;
            case 5:
                layoutId = R.layout.activity_pose5;
                break;
            case 6:
                layoutId = R.layout.activity_pose6;
                break;
            case 7:
                layoutId = R.layout.activity_pose7;
                break;
            case 8:
                layoutId = R.layout.activity_pose8;
                break;
            case 9:
                layoutId = R.layout.activity_pose9;
                break;
            case 10:
                layoutId = R.layout.activity_pose10;
                break;
            case 11:
                layoutId = R.layout.activity_pose11;
                break;
            case 12:
                layoutId = R.layout.activity_pose12;
                break;
            case 13:
                layoutId = R.layout.activity_pose13;
                break;
            case 14:
                layoutId = R.layout.activity_pose14;
                break;
            case 15:
                layoutId = R.layout.activity_pose15;
                break;
            // Add cases for other values as needed
        }

        if (layoutId != 0) {
            setContentView(layoutId);
            startButton = findViewById(R.id.startbutton);
            textView = findViewById(R.id.time);
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        // Initialize the MediaPlayer only once in onCreate
        mediaPlayer = MediaPlayer.create(this, R.raw.tik_tik);
    }

    private void pauseTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            isTimerRunning = false;
            startButton.setText("START");
            mediaPlayer.pause(); // Pause the sound
        }
    }

    private void startTimer() {
        if (!isTimerRunning) {
            if (timeLeftInMillis == 0) {
                // Set the initial timer duration to 1 minute (60,000 milliseconds)
                timeLeftInMillis = 60000; // 1 minute
            }
            countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMillis = millisUntilFinished;
                    updateTimer();
                    playTikTikSound(); // Resume the sound
                }

                @Override
                public void onFinish() {
                    int newValue = Integer.parseInt(buttonValue) + 1;
                    if (newValue <= 15) { // Change the maximum value as needed
                        Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value", String.valueOf(newValue));
                        startActivity(intent);
                    } else {
                        newValue = 1;
                        Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("value", String.valueOf(newValue));
                        startActivity(intent);
                    }
                }
            }.start();
            isTimerRunning = true;
            startButton.setText("PAUSE");
        }
    }

    @Override
    public void onBackPressed() {
        if (isTimerRunning) {
            pauseTimer();
        }
        super.onBackPressed();
    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 60000);
        int seconds = (int) (timeLeftInMillis % 60000 / 1000);
        String timeLeftText = String.format("%02d:%02d", minutes, seconds);
        textView.setText(timeLeftText);
    }

    private void playTikTikSound() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }
}
