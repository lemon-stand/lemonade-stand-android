package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


    //starts in splash then moves to main


    Thread thread = new Thread(){


        @Override
        public void run() {

            try {

                //Show the screen for 3 seconds
                sleep(3000);


                //initiate permissions and loader

                Intent i = new Intent(SplashScreenActivity.this, InitLoader.class);
                SplashScreenActivity.this.startActivity(i);
                System.out.println("perms accepted");


            } catch(Exception e) {

                e.printStackTrace();

            } finally {

                //change from going straight into the mainmenu activity, go into the loginmenu activity(?)
                // yes, change from going straight into mainmenu to go into loginmenu


                Intent mainIntent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                startActivity(mainIntent);


            }
        }
    };

    thread.start();



    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}