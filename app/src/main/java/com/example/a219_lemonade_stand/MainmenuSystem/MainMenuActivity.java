package com.example.a219_lemonade_stand.MainmenuSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;


public class MainMenuActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    private final static long Interval = 30;


    private MainMenuView MainMenuV;





    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();


        MainMenuV = new MainMenuView(this);

        //game state
        setContentView(MainMenuV);
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        MainMenuV.invalidate();
                    }
                });
            }
        }, 0, Interval);*/

    }
}