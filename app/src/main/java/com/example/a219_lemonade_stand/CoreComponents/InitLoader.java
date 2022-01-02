package com.example.a219_lemonade_stand.CoreComponents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.a219_lemonade_stand.R;

public class InitLoader extends AppCompatActivity {


    private int STORAGE_PERM_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_loader);


        Button buttonRequest = findViewById(R.id.b_RequestPerms);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(InitLoader.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(InitLoader.this, "You have already granted this permisson!", Toast.LENGTH_SHORT).show();

                }
                //if permission not granted
                else {
                    requestLocationPermission();

                }


            }
        });

        if(ContextCompat.checkSelfPermission(InitLoader.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(InitLoader.this, "Welcome to Lemonade Stand!", Toast.LENGTH_SHORT).show();
            finish();
        }



    }

    private void requestLocationPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This permission is needed to determine a location for the multiplayer game")
                    .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            ActivityCompat.requestPermissions(InitLoader.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, STORAGE_PERM_CODE);
                        }
                    })
                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create().show();
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, STORAGE_PERM_CODE);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == STORAGE_PERM_CODE)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Permission granted!", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this,"Permission denied!", Toast.LENGTH_SHORT).show();

            }
        }
        finish();


    }
}