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
 *  Main Activity Class that allows the user to login and read playerdata
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Main Activity onCreate Function
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //go to splash screen from start
        Intent i = new Intent(MainActivity.this, SplashScreenActivity.class);
        MainActivity.this.startActivity(i);

    }
}
