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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a219_lemonade_stand.databinding.ActivityMarketBinding;

public class SingleplayerActivity extends AppCompatActivity {



    private Button startday;
    private Button buylemonsbutton;

    private ImageView logo;

    private TextView balance;
    private TextView lemonsamount;
    private TextView sugaramount;
    private TextView wateramount;

    private String moneybalance;
    private String lemonbalance;

    private Button finishday;
    //private ImageView logo;
    private Bitmap stall;
    private Bitmap seller;
    private Bitmap buyer;
    //private TextView balance;
    private TextView lemonscount;
    private TextView sugarcount;
    private TextView watercount;


    private static final int MENU_RESUME = 1;
    private static final int MENU_START = 2;
    private static final int MENU_STOP = 3;

    //private GameThread mGameThread;
    //private GameView mGameView;

    //game loop
    public spGame a1 = new spGame();

    private boolean nextdaycheck = true;

    private SingleplayerView1 spgame1;

    private SingleplayerView2 spgame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //singleplayer game state 1
        spgame1 = new SingleplayerView1(this);


        //singleplayer game state 2 = selling state
        spgame2 = new SingleplayerView2(this);

        setContentView(spgame2);


    }
}