package com.example.a219_lemonade_stand.GameEngineSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;





public class RecipePricingActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;


    private RecipePricingView rpState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        rpState = new RecipePricingView(this);

        //game state
        setContentView(rpState);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        rpState.invalidate();
                    }
                });
            }
        }, 0, Interval);



    }
}