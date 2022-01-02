package com.example.a219_lemonade_stand.CoreComponents;

/**     Import Libraries   **/
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a219_lemonade_stand.CoreComponents.ThreadingSystem.SplashScreenActivity;


/**
 *  Lemonade Stand Application
 *
 *  Start state -> Main Activity
 *  Main Activity Class that starts the Splash Screen Activity
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Main Activity onCreate Function
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Main Activity calls Splash Screen Activity
        Intent intent_SplashScreen = new Intent(MainActivity.this, SplashScreenActivity.class);

        //start Intent of Splash Screen which leads into the Login System Activity
        MainActivity.this.startActivity(intent_SplashScreen);

    }
}
