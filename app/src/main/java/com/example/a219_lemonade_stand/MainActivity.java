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


    //Declaring Views & Variables:

    //Images
    private ImageView logo;
    private ImageView loginscreenimage;

    //Define variables which will be used to login.
    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;
    private TextView reveal;    // used to help display playerdata.txt
    boolean isValid = false;    //boolean variable for checking login

    //admin user. and pass.
    String adminUsername = "admin";
    String adminPassword = "12345";

    //Current temp variables for functionality
    String stringsplittemp = "";
    String usertemp = "";
    String passtemp = "";


    /**
     *  Main Activity onCreate Function
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Referencing xml elements

        //login screen background image
        loginscreenimage = (ImageView) findViewById(R.id.loginscreenimageview);
        loginscreenimage.setImageResource(R.drawable.lemonadestandloginscreen);
        loginscreenimage.setImageAlpha(30);

        //logo image
        logo = (ImageView) findViewById(R.id.LogoView);
        logo.setImageResource(R.drawable.lemonlogo);

        //Username and password elements
        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);
        reveal = (TextView) findViewById(R.id.revealtext);


        /**
         * Function to read player data file text and allocate the data into the appropriate strings
         */
        try {
            InputStream instream = openFileInput("app/src/main/java/com/example/a219_lemonade_stand/playerdata.txt");
            if (instream != null)
            {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line = "";
                try
                {
                    while ((line = buffreader.readLine()) != ";")
                        stringsplittemp += line;

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("doesn't read");
            String error="";
            error=e.getMessage();
        }


        //allocation of the data into the strings
        usertemp.equals(stringsplittemp.split(",", 0));
        System.out.println(usertemp);
        passtemp.equals(stringsplittemp.split(",", 1));
        stringsplittemp.substring(usertemp.length(), passtemp.length() );
        System.out.println(stringsplittemp);
        passtemp.equals(stringsplittemp);

        //reveal text set
        reveal.setText(stringsplittemp + "trying to print username and password");

        /**
         *Function to compare user input with login data, and to prove authenticity.
         *
         */
        eLogin.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {


                String inputName = eUsername.getText().toString();
                String inputPassword = ePassword.getText().toString();

                //Checks if user input is empty
                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter details correctly.", Toast.LENGTH_SHORT).show();
                }

                //
                else{

                    //Function to return a boolean variable to compare to.
                    isValid = validate(inputName, inputPassword);

                    //If user input is false.
                    if (!isValid) {
                        Toast.makeText(MainActivity.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();
                    }

                    //If user input is true, sends state to HomePageActivity.
                    else {
                        Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                        // setContentView(R.layout.homepage_main);
                        // startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                        Intent i = new Intent(MainActivity.this, MainMenuActivity.class);
                        MainActivity.this.startActivity(i);
                    }

                }
            }
        });

    }

    /**
     * Function to validate user input and return a boolean value.
     * @param name      Variable for username
     * @param password  Variable for password
     * @return          Returns boolean value
     */
    private boolean validate(String name, String password){

        if
        ((name.equals(adminUsername) && password.equals(adminPassword))
        ) {
            return true;
        }

        if
        ((name.equals(usertemp) && password.equals(passtemp))
        ){
            return true;
        }
        else {
            return false;
        }

    }

}


