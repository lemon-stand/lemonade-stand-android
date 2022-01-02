package com.example.a219_lemonade_stand.LoginSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;


public class LoginSystemActivity extends AppCompatActivity {



    //Declaring Views & Variables:


    private Handler handler = new Handler();
    private final static long Interval = 30;





    ///     https://developer.android.com/training/volley/simple

    /// http://localhost:8080/api/v1/player
    /// [{"id":1,"name":"Rick","dob":"2000-01-05","email":"Rick@morty.com"},{"id":2,"name":"alexis","dob":"2004-09-21","email":"alexis@gmail.com"}]


    //  https://www.youtube.com/watch?v=y2xtLqP8dSQ&ab_channel=CodinginFlows


    //ipconfig ipv4
    //private static String ip = "191.168.";
    private static String ip = "192.168.0.10";

    //RequestQueue queue = Volley.newRequestQueue(LoginSystemActivity.this);


    public void checkURL() {

        String url = "http://localhost:8080/api/v1/player";

//        //JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
//
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        String playerName = "";
//                        try {
//
//                            JSONArray jsonArray = response.getJSONArray("players");
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//
//                            //doesnt exist
//
//                            //
//                        }
//                        Toast.makeText(LoginSystemActivity.this, "Something wrong.", Toast.LENGTH_SHORT);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });


    }


    String URL = "http://192.168.0.12:8080/api/v1/player";
    private LoginSystemActivityView lsView;

   // private Player lsap = new Player();

    private void showKeyboard(EditText _editText) {

        //InputMethodManger
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

       /* RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null, //what it returns
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest response", response.toString());
                        lsap.setPlayertuple(response.toString());
                        System.out.println("success");


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest response", error.toString());
                        System.out.println("fail");
                    }
                }
        );*/
        //requestQueue.add(objectRequest);

        lsView = new LoginSystemActivityView(this);

        setContentView(lsView);

        //set soft mode
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        //show key
        if(lsView.returneUser() == true){
            //showKeyboard(editText);
        }

        if(lsView.returneUser() == false){

        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        lsView.invalidate();
                    }
                });
            }
        }, 0, Interval);




        /*//logo image
        //logo = (ImageView) findViewById(R.id.LogoView);
        logo.setImageResource(R.drawable.lemonlogo);

        //Username and password elements
        eUsername = findViewById(R.id.etUsername);
        ePassword = findViewById(R.id.etPassword);
        eLogin =  findViewById(R.id.bLogin);
        reveal = (TextView) findViewById(R.id.revealtext);*/






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
        reveal.setText(stringsplittemp + "trying to print username and password");

        *//**
         *Function to compare user input with login data, and to prove authenticity.
         *
         *//*
        eLogin.setOnClickListener(new View.OnClickListener() {

            *//**
             * Function to return boolean value based on user data.
             * @param v
             *//*
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
                        Toast.makeText(LoginSystemActivity.this, "Incorrect details entered.", Toast.LENGTH_SHORT).show();
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

    *//**
     * send text to view?
     *//*
    public void send_text(View v) {

        message = eUsername.getText().toString();
        myTask mt = new myTask();
        mt.execute();

        Toast.makeText(getApplicationContext(), "Data sent", Toast.LENGTH_LONG).show();


    }

    *//**
     * class myTask
     *//*
    class myTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                s = new Socket(ip, 5000);       //connect to socket at port 5000
                printWriter = new PrintWriter((s.getOutputStream()));   //set the outputstream
                printWriter.write(message); //send the message through the server
                printWriter.flush();
                printWriter.close();
                s.close();



            } catch(IOException e) {

                e.printStackTrace();
            }



            return null;
        }
    }

    *//**
     * Function to validate user input and return a boolean value.
     * @param name      Variable for username
     * @param password  Variable for password
     * @return          Returns boolean value
     *//*
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
        }*/

    }

}
