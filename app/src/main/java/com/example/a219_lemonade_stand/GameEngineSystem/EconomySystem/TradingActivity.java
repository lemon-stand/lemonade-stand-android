package com.example.a219_lemonade_stand.GameEngineSystem.EconomySystem;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a219_lemonade_stand.GameEngineSystem.InventoryView;

public class TradingActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private final static long Interval = 30;


    private TradingView tradingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        tradingView = new TradingView(this);



        //game state
        setContentView(tradingView);
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
