package com.example.a219_lemonade_stand.LoginSystem;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterSystemActivityTest extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;


    private RegisterSystemView registerSystemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();


        registerSystemView = new RegisterSystemView(this);

        //game state
        setContentView(registerSystemView);
    }

}
