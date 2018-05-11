package com.abhishek.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean hasRun = false;
    public void bob(View view){
        final MediaPlayer mP;
        mP = MediaPlayer.create(this,R.raw.sound);
        final TextView timerTextView = findViewById(R.id.timerTextView);
        if(hasRun){
            timerTextView.setTextSize(50);
        }
        // Creating a new Countdown timer
        new CountDownTimer(10000,1000) {
            @Override
            // Setting up the onTick Method
            public void onTick(long millisecondsUntilDone) {
                hasRun = true;
                String timeLeft;
                if(millisecondsUntilDone / 1000 >= 10){
                    timeLeft = "00:" + String.valueOf(millisecondsUntilDone / 1000);
                }else {
                    timeLeft = "00:0" + String.valueOf(millisecondsUntilDone / 1000);
                }
                timerTextView.setText(timeLeft);

            }

            @Override
            public void onFinish() {
                timerTextView.setText("CountDown Completed");
                timerTextView.setTextSize(15);
                mP.start();
            }
        }.start();

        /*
        Handler Code is Commented Out
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("just info","A new  Second Passed ");
                handler.postDelayed(this,5000);
            }
        };
        handler.post(runnable);

         */
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
