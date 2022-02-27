package com.example.a219_lemonade_stand.CoreComponents;

/**     Import Libraries   **/
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a219_lemonade_stand.CoreComponents.ThreadingSystem.SplashScreenActivity;
import com.example.a219_lemonade_stand.LoginSystem.LoginSystemActivity;
import com.example.a219_lemonade_stand.LoginSystem.RegisterSystemActivity;
import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;


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


        // NOTE : change class back to splash when threading is ok!
        // Or change from the target to mainmenuactivity
        Intent intent_SplashScreen = new Intent(MainActivity.this, MainMenuActivity.class);
        //Intent intent_SplashScreen = new Intent(MainActivity.this, RegisterSystemActivity.class);


        //Main Activity calls Splash Screen Activity
        //Intent intent_SplashScreen = new Intent(MainActivity.this, LoginSystemActivity.class);

        //start Intent of Splash Screen which leads into the Login System Activity
        MainActivity.this.startActivity(intent_SplashScreen);

    }
}
