package com.example.a219_lemonade_stand.GameEngineSystem.EconomySystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class StoreActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;


    private StoreView StoreV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        StoreV = new StoreView(this);

        //game state
        setContentView(StoreV);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        StoreV.invalidate();
                    }
                });
            }
        }, 0, Interval);

    }
}