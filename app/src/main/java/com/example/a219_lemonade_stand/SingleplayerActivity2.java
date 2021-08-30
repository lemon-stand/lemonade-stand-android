package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class SingleplayerActivity2 extends AppCompatActivity {


    private Button finishday;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_singleplayer2);


        //game loop
        spGame a2 = new spGame();

        a2.useLemons();



        finishday = (Button) findViewById(R.id.bfinday);
        finishday.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {


                Intent i = new Intent(SingleplayerActivity2.this, SingleplayerActivity.class);
                SingleplayerActivity2.this.startActivity(i);
            }
        });

        logo = (ImageView) findViewById(R.id.blogo);
        logo.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SingleplayerActivity2.this, MainMenuActivity.class);
                SingleplayerActivity2.this.startActivity(i);

            }
        });

    }
}