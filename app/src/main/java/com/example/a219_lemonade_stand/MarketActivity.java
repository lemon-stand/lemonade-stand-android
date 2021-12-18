package com.example.a219_lemonade_stand;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a219_lemonade_stand.databinding.ActivityMarketBinding;

import java.util.Timer;
import java.util.TimerTask;

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
        Timer timer = new Timer();
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
        }, 0, Interval);


    }




}