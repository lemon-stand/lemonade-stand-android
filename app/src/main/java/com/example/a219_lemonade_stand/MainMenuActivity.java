package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
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


    private static final int MENU_RESUME = 1;
    private static final int MENU_START = 2;
    private static final int MENU_STOP = 3;

    private GameThread mGameThread;
    private GameView mGameView;


    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



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

                //Set up a new game, we don't care about previous states
               //mGameThread = new TheGame(mGameView);
               //mGameView.setThread(mGameThread);
               //mGameThread.setState(GameThread.STATE_READY);
               //mGameView.startSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));


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

    /*
     * Activity state functions
     */

    @Override
    protected void onPause() {
        super.onPause();

        if(mGameThread.getMode() == GameThread.STATE_RUNNING) {
            mGameThread.setState(GameThread.STATE_PAUSE);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        mGameView.cleanup();
        mGameView.removeSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        mGameThread = null;
        mGameView = null;
    }

    /*
     * UI Functions
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, MENU_START, 0, R.string.menu_start);
        menu.add(0, MENU_STOP, 0, R.string.menu_stop);
        menu.add(0, MENU_RESUME, 0, R.string.menu_resume);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_START:
                mGameThread.doStart();
                return true;
            case MENU_STOP:
                mGameThread.setState(GameThread.STATE_LOSE,  getText(R.string.message_stopped));
                return true;
            case MENU_RESUME:
                mGameThread.unpause();
                return true;
        }

        return false;
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // Do nothing if nothing is selected
    }
}