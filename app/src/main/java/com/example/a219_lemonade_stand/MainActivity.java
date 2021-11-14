package com.example.a219_lemonade_stand;

/**     Import Libraries   **/
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


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
