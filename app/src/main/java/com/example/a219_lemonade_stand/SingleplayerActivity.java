package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a219_lemonade_stand.databinding.ActivityMarketBinding;

import java.util.Timer;
import java.util.TimerTask;

public class SingleplayerActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    private final static long Interval = 30;



    private SingleplayerView1 spgame1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        //singleplayer game state 1
        spgame1 = new SingleplayerView1(this);


        //game state
        setContentView(spgame1);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        spgame1.invalidate();
                    }
                });
            }
        }, 0, Interval);


    }

}