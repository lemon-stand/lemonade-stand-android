package com.example.a219_lemonade_stand;

/**     Import Libraries   **/
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *  Main Activity Class
 */
public class MainActivity extends AppCompatActivity {

    //Images
    private ImageView logo;

    //Define variables which will be used to login.
    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;

    boolean isValid = false;

    String adminUsername = "admin";
    String adminPassword = "12345";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Initialising image
        logo = (ImageView) findViewById(R.id.LogoView);
        logo.setImageResource(R.drawable.lemonlogo);


        //Referencing xml elements
        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);


        try {
            InputStream instream = openFileInput("Playerdata.txt");
            if (instream != null)
            {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line,line1 = "";
                try
                {
                    while ((line = buffreader.readLine()) != ",")
                        line1+=line;
                    //usertemp = line;
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
            String error="";
            error=e.getMessage();
        }


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

        String usertemp = "aa";
        String passtemp = "bb";

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


