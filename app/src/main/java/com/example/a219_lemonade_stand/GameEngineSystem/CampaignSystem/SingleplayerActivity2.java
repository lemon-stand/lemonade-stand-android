package com.example.a219_lemonade_stand.GameEngineSystem.CampaignSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;


public class SingleplayerActivity2 extends AppCompatActivity {


    private Handler handler = new Handler();
    private final static long Interval = 30;


    private SingleplayerView2 spgame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        //singleplayer game state 2 = selling state
        spgame2 = new SingleplayerView2(this);

        //game state
        setContentView(spgame2);
       Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        spgame2.invalidate();
                    }
                });
            }
        }, 0, Interval);



    }
}