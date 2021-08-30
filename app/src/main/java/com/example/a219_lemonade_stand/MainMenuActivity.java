package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainMenuActivity extends AppCompatActivity {


    private Button singleplayer;
    private Button multiplayer;
    private Button market;
    private Button store;
    private Button settings;
    private Button lemonsbutton;
    private ImageView logo;
    private TextView profiletext;
    private ImageView profilebutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        singleplayer =  findViewById(R.id.bsingleplayer);
        multiplayer = findViewById(R.id.bmultiplayer);
        market = findViewById(R.id.bmarket);
        store =  findViewById(R.id.bstore);
        settings = findViewById(R.id.bsettings);
        lemonsbutton = findViewById(R.id.blemons);
        logo = findViewById(R.id.blogo);
        profiletext = findViewById(R.id.textview_profiletext);
        profilebutton = findViewById(R.id.bprofile);


        String s_username = "player 1";
        String s_balance = "$0";
        String lemonstext;

        String s_profiletext = s_username + "\n" + s_balance;

        spGame a1 = new spGame();

        profiletext.setText(s_profiletext);




        singleplayer.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenuActivity.this, SingleplayerActivity.class);
                MainMenuActivity.this.startActivity(i);

            }
        });


        market.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenuActivity.this, MarketActivity.class);
                MainMenuActivity.this.startActivity(i);
            }
        });




        profilebutton.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenuActivity.this, SingleplayerActivity.class);
                MainMenuActivity.this.startActivity(i);

            }
        });







    }
}