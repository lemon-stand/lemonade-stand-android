package com.example.a219_lemonade_stand.MenuSystem;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MultiplayerMenuActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;

    private MultiplayerMenuView multiplayer_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        multiplayer_view = new MultiplayerMenuView(this);

        setContentView(multiplayer_view);


    }
}
