package com.example.a219_lemonade_stand.CoreComponents;

/**     Import Libraries   **/
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a219_lemonade_stand.LoginSystem.LoginSystemActivity;


/**
 *  Lemonade Stand Application
 *
 *  Start state -> Main Activity
 *  Main Activity Class that starts the Splash Screen Activity
 */
public class MainActivity extends AppCompatActivity {



    // STATIC GLOBAL CONSTANT VARIABLE FOR IP
    //public static final String IP_ADDRESS ="http://192.168.1.9:8080/";

    /**
     * Main Activity onCreate Function
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // NOTE : change class back to splash when threading is ok!
        // Or change from the target to mainmenuactivity
        //Intent intent_SplashScreen = new Intent(MainActivity.this, MainMenuActivity.class);
        //Intent intent_SplashScreen = new Intent(MainActivity.this, RegisterSystemActivity.class);


        //Main Activity calls Splash Screen Activity
        Intent intent_SplashScreen = new Intent(MainActivity.this, SplashScreenActivity.class);

        //start Intent of Splash Screen which leads into the Login System Activity
        MainActivity.this.startActivity(intent_SplashScreen);

    }
}
