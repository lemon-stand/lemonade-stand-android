package com.example.a219_lemonade_stand.LoginSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginSystemActivity extends AppCompatActivity {


    //Declaring Views & Variables:

    //Images
    private ImageView logo;
    private ImageView loginscreenimage;

    //Define variables which will be used to login.
    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;

    private Button b_createAccount;
    private TextView reveal;    // used to help display playerdata.txt
    boolean isValid = false;    //boolean variable for checking login

    //admin user. and pass.
    String adminUsername = "admin";
    String adminPassword = "1234";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginsystem);

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




/*


        *//**
         * Function to read player data file text and allocate the data into the appropriate strings
         *//*
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
        reveal.setText(stringsplittemp + "trying to print username and password");*/



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
                    Toast.makeText(LoginSystemActivity.this, "Please enter details correctly.", Toast.LENGTH_SHORT).show();
                }

                //
                else{

                    //Function to return a boolean variable to compare to.
                    isValid = validate(inputName, inputPassword);

                    //If user input is false.
                    if (!isValid) {
                        //Toast.makeText(LoginSystemActivity.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();
                    }

                    //If user input is true, sends state to HomePageActivity.
                    else {
                        Toast.makeText(LoginSystemActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                        // setContentView(R.layout.homepage_main);
                        // startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                        Intent i = new Intent(LoginSystemActivity.this, MainMenuActivity.class);
                        LoginSystemActivity.this.startActivity(i);
                    }

                }
            }
        });

    }


    boolean validatecheck;

    /**
     * Function to validate user input and return a boolean value.
     * @param username      Variable for username
     * @param password  Variable for password
     * @return          Returns boolean value
     */
    private boolean validate(String username, String password){

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://192.168.0.50:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Post post = new Post(username, password);

        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()) {
                    System.out.println("!!!!!!!!!!code:" + response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "access_token: " + postResponse.getAccessToken() + "\n";
                content += "refresh_token: " + postResponse.getRefreshToken() + "\n";
                Toast.makeText(LoginSystemActivity.this, "nice connection", Toast.LENGTH_SHORT).show();
                validatecheck = true;

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(LoginSystemActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                validatecheck = false;

            }
        });



        if (validatecheck) {
            return true;
        }
        else {
            //Toast.makeText(LoginSystemActivity.this, "Something happened.", Toast.LENGTH_SHORT).show();
            return false;
        }

    }



}