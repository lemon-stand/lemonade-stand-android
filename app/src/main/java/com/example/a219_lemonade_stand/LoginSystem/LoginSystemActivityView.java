package com.example.a219_lemonade_stand.LoginSystem;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.GameEngineSystem.Player;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.R;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginSystemActivityView extends View {

    //Images
    private ImageView logo;
    private Bitmap loginscreenimage;

    //Define variables which will be used to login.
    private EditText eUsername;
    private EditText ePassword;
    private Button eLogin;

    private Bitmap uUser;
    private Bitmap bUserText;
    private int b_userX = 50, b_usery = 400, b_entryWidth = 1000, b_entryHeight = 250;

    private static boolean edituser = false;

    public boolean returneUser() { return edituser;};
    public boolean returnePass() { return editpass;};


    private static boolean editpass = false;

    private Bitmap uPass;
    private Bitmap bPassText;
    private int b_passX = 50, b_passY = 700;

    private Bitmap bLogin;
    private int b_loginX = 300, b_loginY= 1000, b_entry2Width = 500;




    private Button b_createAccount;
    private TextView reveal;    // used to help display playerdata.txt
    boolean isValid = false;    //boolean variable for checking login

    //admin user. and pass.
    public String adminUsername = "admin";
    public String adminPassword = "12345";

    //Current temp variables for functionality
    public String stringsplittemp = "";
    public String usertemp = "";
    public String passtemp = "";


    private boolean initCheck = false;

    private String usernameInput;


    private static Socket s;
    //private static ServerSocket ss;
    //private static InputStreamReader osr;
    //private static BufferedReader br;
    private static PrintWriter printWriter;

    String message = "";

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 50, homeButtonY = 1300, homeButtonWidth = 1000, homeButtonHeight = 800;
    private int canvasWidth, canvasHeight;

//    private Bitmap loginscreenimage, uloginscreenimage;
    private Bitmap uloginscreenimage;

    private Paint scorePaint = new Paint();
    private Paint scorePaint2 = new Paint();

    public String outputstring = "";

    private Player lsav = new Player();















    private static Boolean checkOnline = false;

    private boolean getcheck() {
        return checkOnline;
    }

    private int onlineX = 650, onlineY = 1700, onlineSize =100;

    private Bitmap unscaledoffline;
    private Bitmap offline_icon;

    private Bitmap unscaledonline;
    private Bitmap online_icon;

    private String s_online = "";

    public LoginSystemActivityView(Context context) {
        super(context);

        unscaledoffline = BitmapFactory.decodeResource(getResources(), R.drawable.offline_icon);
        offline_icon = Bitmap.createScaledBitmap(unscaledoffline, onlineSize, onlineSize, false);

        unscaledonline = BitmapFactory.decodeResource(getResources(), R.drawable.online_icon);
        online_icon = Bitmap.createScaledBitmap(unscaledonline, onlineSize, onlineSize, false);

        uUser = BitmapFactory.decodeResource(getResources(), R.drawable.inventory_icon);
        bUserText = Bitmap.createScaledBitmap(uUser, b_entryWidth, b_entryHeight, false);

        bLogin = Bitmap.createScaledBitmap(uUser, b_entry2Width, b_entryHeight, false);

        uPass = BitmapFactory.decodeResource(getResources(), R.drawable.inventory_icon);
        bPassText = Bitmap.createScaledBitmap(uPass, b_entryWidth, b_entryHeight, false);

       eUsername = new EditText(context);

       eUsername.setLayoutParams(new AbsListView.LayoutParams(b_entryWidth - 300, b_entryHeight));


       ePassword = new EditText(context);
       ePassword.setLayoutParams(new AbsListView.LayoutParams(b_entryWidth - 500, b_entryHeight));



        //http://192.168.0.12:8080/api/v1/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()) {
                    System.out.println("code:" + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts ) {

                    int bo = 0;

                    String content = "";
                    content+="ID: " + post.getId() + "\n";
                    content+="Name: " + post.getName() + "\n";
                    content+="dob: " + post.getDob() + "\n";
                    content+="email: " + post.getEmail() + "\n";

                    lsav.setPlayertuple(content);
                    checkOnline = true;
                    if(content != null){
                        checkOnline = true;

                        //System.out.println(content);
                    }
                    bo++;

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.out.println("error" + t.getMessage());
            }
        });














        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.lemonlogo);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);
        //login screen background image
        uloginscreenimage = BitmapFactory.decodeResource(getResources(), R.drawable.lemonadestandloginscreen);
        loginscreenimage = Bitmap.createScaledBitmap(uloginscreenimage, 1000, 2000, false);


        //s = Bitmap.createScaledBitmap(uloginscreenimage, 1000, 2000, false);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        scorePaint2.setColor(Color.BLACK);
        scorePaint2.setTextSize(100);
        scorePaint2.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint2.setAntiAlias(true);
        scorePaint2.setFlags(Paint.UNDERLINE_TEXT_FLAG);






        outputstring= lsav.getPlayertuple();
        System.out.println("hellllllooo" + outputstring);















    }



    public String getFromURL() {

        String url_tuple ="";



        //http://192.168.0.12:8080/api/v1/player




        return url_tuple;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawText(String.valueOf(eUsername), b_userX + 300, b_usery+150, scorePaint);
        canvas.drawText(String.valueOf(ePassword), b_passX + 300, b_passY+150, scorePaint);


        canvas.drawBitmap(loginscreenimage, 0, 0, null);

        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);


        canvas.drawBitmap(bUserText, b_userX, b_usery, null);
        canvas.drawText("Username: " , b_userX +50, b_usery + 150, scorePaint);

        canvas.drawBitmap(bLogin, b_loginX, b_loginY, null);
        canvas.drawText("Login " , b_loginX +150, b_loginY + 150, scorePaint);


        canvas.drawBitmap(bPassText, b_passX, b_passY, null);
        canvas.drawText("Password: " , b_passX +50, b_passY + 150, scorePaint);

        canvas.drawText("hello: " + outputstring, 50, 300, scorePaint);



        /*if(!edituser) { // disable editing password
            eUsername.setFocusable(false);
            eUsername.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
            eUsername.setClickable(false); // user navigates with wheel and selects widget

        }
        if(edituser){ // enable editing of password
            eUsername.setFocusable(true);
            eUsername.setFocusableInTouchMode(true);
            eUsername.setClickable(true);




        }*/


        if(getcheck() == false) {
            canvas.drawBitmap(offline_icon, onlineX, onlineY, null);
            s_online = "Offline";
        }
        else {
            canvas.drawBitmap(online_icon, onlineX, onlineY, null);
            s_online = "Online";
        }

        canvas.drawText(s_online, 420, 1780, scorePaint);
        canvas.drawText("Server Status:", 350, 1680, scorePaint);

        canvas.drawText("Lemonade Stand:" , 50, 100, scorePaint2);
        canvas.drawText("A Multiplayer Interpretation" , 50, 200, scorePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();


        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if( x > b_userX && x < b_userX + b_entryWidth && y > b_usery && y < b_usery + b_entryHeight ) {

                    edituser=true;
                    System.out.print("entering username");

                    Toast.makeText(getContext(), "entering usernam", Toast.LENGTH_SHORT).show();

                }



                if( x > homeButtonX && x < homeButtonX + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {



                }
                return true;
        }





        return false;
    }


}

