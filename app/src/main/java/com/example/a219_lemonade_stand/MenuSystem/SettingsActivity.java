package com.example.a219_lemonade_stand.MenuSystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.a219_lemonade_stand.LoginSystem.LoginSystemActivity;
import com.example.a219_lemonade_stand.R;
import com.google.android.material.slider.Slider;

import java.util.ServiceLoader;


/**
 *
 *
 *
 *
 * settings where you can toggle to censor all private datavalues
 * such as the balance and how much stock... maybe email or profile name
 *
 * links to profile activity?? -->> is profile activity
 *
 *
 *
 *
 *
 *
 */






public class SettingsActivity extends AppCompatActivity {


    private ImageView home_button;

    private CheckBox gamesoundscheckbox;
    private CheckBox musicsoundscheckbox;

    private Slider volumeslider;

    private Button profilesettings_button;
    private Button graphicssettings_button;
    private Button permssettings_button;
    private Button logout_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        home_button = (ImageView) findViewById(R.id.bhomebutton);
        profilesettings_button = findViewById(R.id.profilebutton);
        graphicssettings_button = findViewById(R.id.graphicssettsbutton);
        permssettings_button = findViewById(R.id.permsbutton);
        logout_button = findViewById(R.id.logoutbutton);


        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, MainMenuActivity.class);
                SettingsActivity.this.startActivity(i);

            }
        });

        profilesettings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Profile Settings under construction.", Toast.LENGTH_SHORT).show();

            }
        });

        graphicssettings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Graphics Settings under construction.", Toast.LENGTH_SHORT).show();

            }
        });

        permssettings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsActivity.this, "Permissions Settings under construction.", Toast.LENGTH_SHORT).show();

            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, LoginSystemActivity.class);
                SettingsActivity.this.startActivity(i);

            }
        });

    }
}