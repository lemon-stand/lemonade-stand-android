package com.example.a219_lemonade_stand.GameEngineSystem.CampaignSystem;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.ServerDeets;
import com.example.a219_lemonade_stand.GameEngineSystem.GameObject;
import com.example.a219_lemonade_stand.GameEngineSystem.Player;
import com.example.a219_lemonade_stand.R;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingleplayerView2 extends View {












    //
    private static int changebuyer1X[] = new int[3];

    Random chance = new Random();
    private static int o2tchance[] = new int[3];


    ///
    Random random = new Random();
    static int number[] = new int[3];
    static int number2[] =new int[3];

    ///////////////////////////////////////

    static int changebuyer2X[] = new int[3];

    Random chance2 = new Random();
    static int o2tchance2[] = new int[3];


    ///
    Random random2 = new Random();
    static int number3[] = new int[3];
    static int number4[] = new int[3];

    /////////////



    private int rainX;
    private int rainY;
    private int rainSpeed = 20;
    private Paint rainPaint = new Paint();

    //private int rainX, rainY, rainSpeed = 20;
    //private Paint rainPaint = new Paint();



    private int canvasWidth, canvasHeight;

    private boolean touch = false;

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;

    private Bitmap backgroundImage;
    private Bitmap unscaledbg;

    private Bitmap stall;
    private Bitmap unscaledstall;

    private Bitmap seller;
    private Bitmap unscaledseller;
    private int sellerX, sellerY;


    private int stockImageX, stockImageY, stockImageWidth = 300, stockImageHeight = 300;
    private Bitmap stockimage;
    private Bitmap unscaledstockimage;

    private int ffX, ffY, ffWidth = 300, ffHeight = 300;
    private Bitmap ffbutton;
    private Bitmap unscaledffbutton;


    private Paint scorePaint = new Paint();

    private Paint smallText = new Paint();

    private int gametime;
    private int hours;
    private int minutes;

    private String s_gametime = "";


    public int getgametime() {
        return gametime;
    }

    private String weathertext = "39\u00B0";


    private String lemonstock = "Lemons: null g.";
    private String waterstock = "Water: null ml.";
    private String sugarstock = "Sugar: null g.";
    private String s_Balance = "Balance: $ null";

    private int money;


    private static GameObject sp2GameObject = new GameObject();

    private static Player sp2Player = new Player();
    private int avatarChoice;


    private Bitmap lemonstandbg, ulemonstandbg;


    private Bitmap ustreet, street_map, upark, park_map, suburb_map, usuburb;

    private int locationcheck = 1;

    ///
    ///

    int sp_weatherstate = sp2GameObject.getWeatherState();

    private int weather_iconX =380, weather_iconY =1700, weather_iconWidth = 200, weather_icon_Height = 200;
    private Bitmap unscaledweathericon;
    private Bitmap weathericon;
    private int weatherselect;


    ////
    ///
    private int numberbuyers = 4;

    private Bitmap buyer[][] = new Bitmap[2][numberbuyers];
    private static int buyerX[] = new int[4];
    private static int buyerY[] = new int[4];
    private static int buyerSpeed[] = new int[4];
    private static int buyerXStep[] = new int[4];
    private static int buyerYStep[] = new int[4];

    private int initbuyerstep1X,initbuyerstep1Y , initbuyerstep2X, initbuyerstep2Y;
    private int initcheck =0;


    private Bitmap buyer2[][] = new Bitmap[2][numberbuyers];
    private static int buyerX2[] = new int[4];
    private static int buyerY2[] = new int[4];
    private static int buyerSpeed2[] = new int[4];
    private static int buyerXStep2[] = new int[4];
    private static int buyerYStep2[] = new int[4];



    //


    private String player_string_inventory ="";


    private Bitmap unscaledknife;
    private Bitmap unscaledcooler;

    private Bitmap emptyslot;
    private Bitmap unscaledemptyslot;

    private Bitmap slot1;
    private int slot1X = 300 , slot1Y =1650 , slotWidth = 100, slotHeight = 100;


    private Bitmap slot3;
    private int slot3X = 300, slot3Y =1750;



    private Bitmap slot2;
    private int slot2X = 300, slot2Y= 1850;


    /**
     * Need to implement an on end void function with deals with post and udpating the game values properly
     */






    public SingleplayerView2(Context context) {
        super(context);

        unscaledemptyslot = BitmapFactory.decodeResource(getResources(), R.drawable.empty_icon);
        unscaledknife = BitmapFactory.decodeResource(getResources(), R.drawable.knife);
        unscaledcooler = BitmapFactory.decodeResource(getResources(), R.drawable.icecooler);


        player_string_inventory = sp2Player.getSelectedInvent();

        char invent1_choice = player_string_inventory.charAt(0);
        slot1 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);


        switch(invent1_choice) {
            case 'K':
                slot1 = Bitmap.createScaledBitmap(unscaledknife, slotWidth, slotHeight, false);
                break;
            case 'Z':
                slot1 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);
                break;
            case 'C':
                slot1 = Bitmap.createScaledBitmap(unscaledcooler, slotWidth, slotHeight, false);
                break;

        }


        char invent2_choice = player_string_inventory.charAt(1);
        slot2 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);

        switch(invent2_choice) {
            case 'K':
                slot2 = Bitmap.createScaledBitmap(unscaledknife, slotWidth, slotHeight, false);
                break;
            case 'Z':
                slot2 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);
                break;
            case 'C':
                slot2 = Bitmap.createScaledBitmap(unscaledcooler, slotWidth, slotHeight, false);
                break;

        }


        char invent3_choice = player_string_inventory.charAt(2);
        slot3 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);

        switch(invent3_choice) {
            case 'K':
                slot3 = Bitmap.createScaledBitmap(unscaledknife, slotWidth, slotHeight, false);
                break;
            case 'Z':
                slot3 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);
                break;
            case 'C':
                slot3 = Bitmap.createScaledBitmap(unscaledcooler, slotWidth, slotHeight, false);
                break;

        }











        ustreet = BitmapFactory.decodeResource(getResources(), R.drawable.street_level_icon);
        street_map = Bitmap.createScaledBitmap(ustreet,  1100, 2000, false);

        upark = BitmapFactory.decodeResource(getResources(), R.drawable.park_level_icon);
        park_map = Bitmap.createScaledBitmap(upark,  1100, 2000, false);

        usuburb = BitmapFactory.decodeResource(getResources(), R.drawable.suburban_level_icon);
        suburb_map = Bitmap.createScaledBitmap(usuburb,  1100, 2000, false);



        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);



        weatherselect = 0;



        weatherselect = sp_weatherstate;

        if(weatherselect == 0) {
            unscaledweathericon = BitmapFactory.decodeResource(getResources(), R.drawable.sunny_icon);
        }
        if(weatherselect == 2) {
            unscaledweathericon = BitmapFactory.decodeResource(getResources(), R.drawable.snowy_icon);
        }
        if(weatherselect == 3) {
            unscaledweathericon = BitmapFactory.decodeResource(getResources(), R.drawable.windy_icon);
        }
        if(weatherselect == 1) {
            unscaledweathericon = BitmapFactory.decodeResource(getResources(), R.drawable.rainy_icon);
        }
        weathericon = Bitmap.createScaledBitmap(unscaledweathericon, weather_iconWidth, weather_icon_Height, false);


        int int_temp = sp2GameObject.getTemperature();

        //change number of buyers algorithm based on weather
        Random rand = new Random();
        int randompopulation = rand.nextInt((4 - 1) + 1) + 1;

        if(weatherselect ==0) {

            numberbuyers = randompopulation;

        }

            randompopulation = rand.nextInt((2 - 1) + 1) + 1;

        if((weatherselect ==3) || (int_temp < 15)){

            numberbuyers = randompopulation;
        }
            randompopulation = 1;

       //snow
        if((weatherselect == 1) || (int_temp < 5)){

            numberbuyers = randompopulation;
        }











        avatarChoice = 0;
        avatarChoice = sp2Player.getCharacterDesign();

        if(avatarChoice == 0) {
            unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.character_bob);

        }
        if(avatarChoice == 1) {
            unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.character_james);

        }
        if(avatarChoice == 2) {
            unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.character_edna);

        }
        if(avatarChoice == 3) {
            unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.character_don);

        }

        seller = Bitmap.createScaledBitmap(unscaledseller, 300, 300, false);


        for(int i = 0; i < buyer.length; i++) {

            buyer[i][0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic1);
            buyer[i][0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic2);

            buyer2[i][0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic1);
            buyer2[i][0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic2);

        }







       // unscaledbg = BitmapFactory.decodeResource(getResources(), R.drawable.location1);
       // backgroundImage = Bitmap.createScaledBitmap(unscaledbg, 1000, 1600, false);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.menubutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledstall = BitmapFactory.decodeResource(getResources(), R.drawable.stall_icon);
        stall = Bitmap.createScaledBitmap(unscaledstall, 500, 700, false);




        unscaledstockimage = BitmapFactory.decodeResource(getResources(), R.drawable.stockimage);
        stockimage = Bitmap.createScaledBitmap(unscaledstockimage, stockImageWidth, stockImageHeight, false);

        unscaledffbutton = BitmapFactory.decodeResource(getResources(), R.drawable.ffbuton);
        ffbutton = Bitmap.createScaledBitmap(unscaledffbutton, ffWidth, ffHeight, false);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        smallText.setColor(Color.CYAN);
        smallText.setTextSize(30);
        smallText.setTypeface(Typeface.DEFAULT_BOLD);
        smallText.setAntiAlias(true);

        rainPaint.setColor(Color.CYAN);
        rainPaint.setAntiAlias(false);




        for(int i = 0; i <= buyer.length; i++) {

            buyerX[i] = 0;
            buyerY[i] = 900;

            buyerX2[i] = 1100;
            buyerY2[i] = 900;

        }


        sellerX = 550;
        sellerY = 950;



        money = 0;
        gametime = 10000;

        hours = 9;
        minutes = 0;

        initcheck ++;



    }

    private String serverString = ServerDeets.IP_ADDRESS;
    private void getPostData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(serverString)

                //.baseUrl("localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //Post loginpost = new Post(username, password);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()) {
                    System.out.println("code:" + response.code());


                }

                List<Post> tempPost = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";

                for(Post post : tempPost) {

                    if(post.getName().equals(sp2Player.s_getPlayerName(1))){
                        //if(post.getName().equals(sp1Player.s_getPlayerName(1))){

                        sp2Player.setChosenPlayerName(sp2Player.s_getPlayerName(1));
                        sp2Player.setChosenPlayerBalance("" + post.getBalance());
                        sp2Player.setPlayer_ID(post.getId());
                        System.out.println("Balance print:" + post.getBalance());



                        sp2Player.setChosenPlayerStock(
                                post.getLemons(),
                                post.getShiny_lemons(),
                                post.getHoney(),
                                post.getSugar(),
                                post.getWater()
                        );
                    }

                }



            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {



            }
        });



    }



    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawBitmap(lemonstandbg, 0, 0, null);

        lemonstock = "used Lemons: " + sp2GameObject.getLemons();
        waterstock = "used Water: " + sp2GameObject.getWater();
        sugarstock = "used Sugar: " + sp2GameObject.getSugar();


        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        ffX = canvas.getWidth() - ffbutton.getWidth() - 20;
        ffY = canvas.getHeight() - ffbutton.getHeight() - 20;



       // canvas.drawBitmap(backgroundImage, 0, 50, null);


        //locationcheck = sp2GameObject.getSellLocation();
        locationcheck = 0;

        if(locationcheck == 0) {
            canvas.drawBitmap(street_map, 0, 0, null);

        }
        if(locationcheck == 1) {
            canvas.drawBitmap(park_map, 0, 0, null);

        }
        if(locationcheck == 2) {
            canvas.drawBitmap(suburb_map, 0, 0, null);

        }



        if(minutes>=60) {
            hours ++;
            minutes =0;
        }

        String s_minutes;
        String s_hours;

        if(hours <= 9) {
            s_hours = "0" + hours;

        } else {
            s_hours = "" + hours;

        }

        if(minutes <= 9) {
            s_minutes = "0" + minutes;

        } else {
            s_minutes = "" + minutes;

        }

        s_gametime = s_hours + ":" + s_minutes;


        s_Balance = "Revenue: $ " + sp2GameObject.getBalance();
        int i_BalX = 400;
        int i_BalY = 100;

        int temp_text = sp2GameObject.getTemperature();

        int weathercheckstring = sp2GameObject.getWeatherState();
        String weatherString = "s";
        if(weathercheckstring == 0) {
            weatherString = "Sunny";
        }
        if(weathercheckstring == 1) {
            weatherString = "Rainy";
        }
        if(weathercheckstring == 2) {
            weatherString = "Snowy";
        }
        if(weathercheckstring == 3) {
            weatherString = "Windy";
        }



/////
        // buyer
        /////



        int minBuyerY = 600;
        int maxBuyerY = canvasHeight + buyer[1][0].getHeight();

        int minBuyerX = 0;
        int maxBuyerX = canvasWidth + buyer[1][0].getWidth();


        for(int i = 0; i <= buyer.length-1; i++) {


            changebuyer1X[i] = 1;

            o2tchance[i] = chance.nextInt(3) + -1;



            if (buyerX[i] >= 800) {

                if (changebuyer1X[i] == 1) {


                    if (o2tchance[i] == 1) {
                        changebuyer1X[i] = 1;
                    }

                    if (o2tchance[i] >= 2) {
                        changebuyer1X[i] = -1;

                    }

                }


            }



            number[i]= random.nextInt(3 - -1) + -1;


            number2[i] = random.nextInt(3 - -1) + -1;


            buyerSpeed[i] = 3;

            buyerYStep[i] = buyerYStep[i] + buyerSpeed[i] * number[i];

            if (initcheck >= 2) {
                initbuyerstep1Y = buyerYStep[i];
            }
            if (initcheck >= 2) {
                initbuyerstep1X = buyerXStep[i] * changebuyer1X[i];
            }


            buyerXStep[i] = buyerXStep[i] + buyerSpeed[i] * number2[i];


            buyerY[i] = buyerY[i] + buyerYStep[i];

            buyerX[i] = buyerX[i] + buyerXStep[i];


            if (buyerY[i] < minBuyerY) {
                //buyerY = maxBuyerY;
                buyerX[i] = 0;
                buyerY[i] = 900;
                buyerYStep[i] = initbuyerstep1Y;
                buyerXStep[i] = initbuyerstep1X;

                buyerSpeed[i] = 3;
                changebuyer1X[i] = 1;
            }
            if (buyerY[i] > maxBuyerY) {
                //buyerY = minBuyerY;
                buyerX[i] = 0;
                buyerY[i] = 1000;
                buyerYStep[i] = initbuyerstep1Y;
                buyerXStep[i] = initbuyerstep1X;

                buyerSpeed[i] = 3;
                changebuyer1X[i] = 1;
            }

            if (buyerX[i] < minBuyerX) {
                //buyerX = maxBuyerX;
                buyerX[i] = 0;
                buyerY[i] = 1000;
                buyerYStep[i] = initbuyerstep1Y;
                buyerXStep[i] = initbuyerstep1X;

                buyerSpeed[i] = 3;
                changebuyer1X[i] = 1;
            }
            if (buyerX[i] > maxBuyerX) {
                //buyerX = minBuyerX;
                buyerX[i] = 0;
                buyerY[i] = 1000;
                buyerYStep[i] = initbuyerstep1Y;
                buyerXStep[i] = initbuyerstep1X;

                buyerSpeed[i] = 3;
                changebuyer1X[i] = 1;
            }


            canvas.drawBitmap(buyer[i][0], buyerX[i],  buyerY[i],  null);

        }



        for(int i = 0; i <= buyer2.length -1; i++) {

            changebuyer2X[i] = -1;

            o2tchance2[i] = chance2.nextInt(3) + -1;

            if (buyerX[i] <= 400) {

                if (changebuyer2X[i] == -1) {


                    if (o2tchance2[i] == 1) {
                        changebuyer2X[i] = 1;
                    }

                    if (o2tchance2[i] >= 2) {
                        changebuyer2X[i] = -1;

                    }

                }


            }



                   number3[i] = random2.nextInt(3 - -1) + -1;

                    number4[i] = random2.nextInt(3 - -1) + -1;

                    buyerSpeed2[i] = 3;

            buyerYStep2[i] = buyerYStep2[i] + buyerSpeed2[i] * number3[i];

            if (initcheck >= 2) {
                initbuyerstep2Y = buyerYStep2[i];
            }
            if (initcheck >= 2) {
                initbuyerstep2X = buyerXStep2[i] * changebuyer2X[i];
            }

            buyerXStep2[i] = buyerXStep2[i] + buyerSpeed2[i] * number4[i];

            buyerY2[i] = buyerY2[i] + buyerYStep2[i];

            buyerX2[i] = buyerX2[i] - buyerXStep2[i];


            if (buyerY2[i] < minBuyerY) {
                //buyerY2 = maxBuyerY;
                buyerX2[i] = 1100;
                buyerY2[i] = 900;
                buyerYStep2[i] = initbuyerstep2Y;
                buyerXStep2[i] = initbuyerstep2X;

                buyerSpeed2[i] = 3;
                changebuyer2X[i] = 1;
            }
            if (buyerY2[i] > maxBuyerY) {
                //buyerY2 = minBuyerY;
                buyerX2[i] = 1100;
                buyerY2[i] = 900;
                buyerYStep2[i] = initbuyerstep2Y;
                buyerXStep2[i] = initbuyerstep2X;

                buyerSpeed2[i] = 3;
                changebuyer2X[i] = 1;
            }

            if (buyerX2[i] < minBuyerX) {
                //buyerX2 = maxBuyerX;
                buyerX2[i] = 1100;
                buyerY2[i] = 900;
                buyerYStep2[i] = initbuyerstep2Y;
                buyerXStep2[i] = initbuyerstep2X;

                buyerSpeed2[i] = 3;
                changebuyer2X[i] = 1;
            }
            if (buyerX2[i] > maxBuyerX) {
                //buyerX2 = minBuyerX;
                buyerX2[i] = 1100;
                buyerY2[i] = 900;
                buyerYStep2[i] = initbuyerstep2Y;
                buyerXStep2[i] = initbuyerstep2X;

                buyerSpeed2[i] = 3;
                changebuyer2X[i] = 1;
            }

            canvas.drawBitmap(buyer2[i][0], buyerX2[i],  buyerY2[i],  null);

        }





        ///




        if(touch)  {

            //canvas.drawBitmap(buyer[1], buyerX,  buyerY,  null);
            touch = false;
        }
        else {



        }


        if(customerpurchasechecker(sellerX, sellerY)) {

            sp2GameObject.useLemons();
        }


        rainY = rainY - rainSpeed;
        if(rainY < 0) {
            rainY = canvasHeight + 21;
            rainX = (int) Math.floor(Math.random() * (canvasWidth - 0)) + 0;
        }

        //canvas.drawLine(rainX, rainY, rainX+15, rainY+25, rainPaint);


        minutes++;
        gametime = gametime - 2;

        //if(gametime <= 0)

        if(hours >= 17)  {
            Toast.makeText(getContext(), "End of the day", Toast.LENGTH_SHORT).show();
            Intent intent_EndDay = new Intent(getContext(), SingleplayerActivity.class);
            intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(intent_EndDay);


        }

        stockImageX =  20;
        stockImageY = canvas.getHeight() - ffbutton.getHeight() - 20;


        ///////
        canvas.drawBitmap(slot3, slot3X, slot3Y, null);
        canvas.drawBitmap(slot2, slot2X, slot2Y, null);
        canvas.drawBitmap(slot1, slot1X, slot1Y, null);

        canvas.drawBitmap(stockimage, stockImageX, stockImageY, null);

        canvas.drawBitmap(weathericon, weather_iconX, weather_iconY, null);


        canvas.drawText("Temp: " + weatherString, 430, 1650, scorePaint);
        canvas.drawText("" + temp_text, 600, 1800, scorePaint);
        canvas.drawText("Time: " + s_gametime , 600, 200, scorePaint);

        canvas.drawText(lemonstock, stockImageX + 50, stockImageY + 80, smallText);
        canvas.drawText(waterstock, stockImageX + 50, stockImageY + 180, smallText);
        canvas.drawText(sugarstock, stockImageX + 50, stockImageY + 280, smallText);


        canvas.drawText(s_Balance, i_BalX, i_BalY +50 , smallText);

//////////////////string identifier seperation

        String player_bal = sp2Player.s_getPlayerBalance(1);


        String player_lemons =  "" + sp2Player.returnLemonStock();
        String player_sugar =  "" + sp2Player.getSugar();
        String player_water =  "" + sp2Player.getWater();


        canvas.drawText("Balance: $" + player_bal, i_BalX, i_BalY , scorePaint);


        canvas.drawText("Lemons:" + player_lemons, stockImageX, stockImageY+50, scorePaint);
        canvas.drawText("Water: " + player_water, stockImageX, stockImageY+ 150, scorePaint);
        canvas.drawText("Sugar: " + player_sugar, stockImageX, stockImageY + 250, scorePaint);



        canvas.drawBitmap(seller, sellerX, sellerY, null);
        canvas.drawBitmap(stall, 250, 850, null);

        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);
        canvas.drawBitmap(ffbutton, ffX, ffY, null);









    }

    public boolean customerpurchasechecker(int x, int y) {

        for(int i = 0; i <= buyer2.length; i++) {


            if(buyerX[i] < x && x < (buyerX[i] + buyer[1][0].getWidth()) && buyerY[i] < y && y < (buyerY[i] + buyer[1][0].getHeight())) {

                return true;
            }
            if(buyerX2[i] < x && x < (buyerX2[i] + buyer2[1][0].getWidth()) && buyerY2[i] < y && y < (buyerY2[i] + buyer2[1][0].getHeight())) {

                return true;
        }
        }

        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if( x > ffX && x < ffX + ffWidth && y > ffY && y < ffY + ffHeight ) {


                    Toast.makeText(getContext(), "End of the day", Toast.LENGTH_SHORT).show();
                    Intent intent_EndDay = new Intent(getContext(), SingleplayerActivity.class);
                    intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    getContext().startActivity(intent_EndDay);

                }
                if( x > homeButtonX && x < homeButtonX + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {

                    //set true to display request.
                    //dont pause game??
                    //then go into another check for accept or deny

                    //intent or set false to bool

                    //Toast.makeText(getContext(), "End of the day", Toast.LENGTH_SHORT).show();
                    //Intent intent_EndDay = new Intent(getContext(), SingleplayerActivity.class);
                    //intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    //getContext().startActivity(intent_EndDay);

                }

                return true;
        }
        return false;
    }
}

