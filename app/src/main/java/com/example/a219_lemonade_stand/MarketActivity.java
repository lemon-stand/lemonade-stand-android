package com.example.a219_lemonade_stand;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.a219_lemonade_stand.databinding.ActivityMarketBinding;

public class MarketActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMarketBinding binding;

    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


        logo = (ImageView) findViewById(R.id.blogo);
        logo.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MarketActivity.this, MainMenuActivity.class);
                MarketActivity.this.startActivity(i);

            }
        });

    }


}