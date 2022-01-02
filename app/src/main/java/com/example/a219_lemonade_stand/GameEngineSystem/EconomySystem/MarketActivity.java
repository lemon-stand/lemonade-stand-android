package com.example.a219_lemonade_stand.GameEngineSystem.EconomySystem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

public class MarketActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;


    private MarketView marketState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //getSupportActionBar().hide();


        marketState = new MarketView(this);

        //game state
        setContentView(marketState);
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        marketState.invalidate();
                    }
                });
            }
        }, 0, Interval);*/


    }




}