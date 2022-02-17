package com.example.a219_lemonade_stand.GameEngineSystem;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class InventoryActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long Interval = 30;


    private InventoryView inventoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        inventoryView = new InventoryView(this);



        //game state
        setContentView(inventoryView);
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        inventoryView.invalidate();
//                    }
//                });
//            }
//        }, 0, Interval);



    }

}
