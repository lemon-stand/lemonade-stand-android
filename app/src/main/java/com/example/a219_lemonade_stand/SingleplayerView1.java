/**
 * Lemonade Stand - Singleplayer View 1
 * 19129576
 * come219
 */
package com.example.a219_lemonade_stand;

/**
 *  Import Libraries
 */
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

/**
 * Singleplayer View 1 Class
 * Soon to change name to Campaign to better suit name and not confuse the game as being
 * local only or as a serparate stand-alone game
 *
 * Game state describes the moment where the player can see their previous return,
 * they can also directly see their stock and recipes, they have access to change the recipe or stock,
 * finally the player can choose to start the game state and sell some lemons! yay!
 */
public class SingleplayerView1 extends View {

    private Bitmap seller;
    private Bitmap unscaledseller;
    private int profileX , profileY , profileWidth = 300, profileHeight = 300;
    private String lemonstock = "lemons: ";
    private String waterstock = "water: ";
    private String sugarstock = "sugar: ";

    private String forecastString = "Forecast:";   //implement forecost on the state

    private String s_Revenue = "Revenue: ";
    private String s_Overhead = "Overhead: ";
    private String s_Profit = "Profit: ";

    private Paint scorePaint = new Paint();
    private Paint scorePaint2 = new Paint();


    private Bitmap locationImage;
    private Bitmap unscaledlLcationImage;
    private int locationImageX , locationImageY , locationImageWidth = 500, locationImageHeight = 300;

    //private Bitmap changeserverbutton;
    //private Bitmap unscaledserver;
    //private int changeserverX , changeserverY , changeserverWidth = 500, changeserverHeight = 300;

    private Bitmap recipepricingButton;
    private Bitmap unscaledrecipepricing;
    private int rpX = 50, rpY = 800, rpWidth = 300, rpHeight = 250;


    private Bitmap storeButton;
    private Bitmap unscaledstore;
    private int storeX = 50, storeY = 1200, storeWidth = 300, storeHeight = 250;



    private Bitmap unscaledknife;


    private Bitmap slot1;
    private int slot1X = 100 , slot1Y =400 , slotWidth = 200, slotHeight = 200;


    private Bitmap slot3;
    private int slot3X = 800, slot3Y =400 , slot3Width = 200, slot3Height = 200;


    private Bitmap unscaledcooler;
    private Bitmap slot2;

    private int slot2X = 400, slot2Y= 400;

    private int forecastX =50, forecastY =1700, forecastWidth = 250, forecastHeight = 200;
    private Bitmap unscaledforecast;
    private Bitmap forecast;

    private int weather_iconX =380, weather_iconY =1700, weather_iconWidth = 200, weather_icon_Height = 200;
    private Bitmap unscaledweathericon;
    private Bitmap weathericon;
    private int weatherselect;


    private int arrowX , arrowY , arrowWidth = 300, arrowHeight = 300;
    private Bitmap unscaledarrow;
    private Bitmap goarrow;
    private boolean arrowClicked= false;
    public int prevmoney;

    public boolean getarrowClicked() { return arrowClicked; };

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;



    private Bitmap emptyslot;
    private Bitmap unscaledemptyslot;


    private boolean touch = false;


    private Bitmap uinventmgment;
    private Bitmap inventmgmente;
    private int inventmgmtX = 50, inventmgmtY = 450, inventmgmtWidth = 980, inventmgmtHeight = 1500;



    private Bitmap usave;
    private Bitmap save_icon;

    private Bitmap uexit;
    private Bitmap exit_icon;

    private int avatarChoice;


    GameObject sp1GameObject = new GameObject();

    Player sp1Player = new Player();

    private String player_string_inventory ="";

    private static boolean showInventoryManagement =false;


    /**
     * SingleplayerView1 Constructor Function that assigns all the objects to their attributes,
     *                   ready to be used by the canvas
     * @param context
     */
    public SingleplayerView1(Context context) {
        super(context);






        scorePaint.setColor(Color.MAGENTA);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        scorePaint2.setColor(Color.BLACK);
        scorePaint2.setTextSize(50);
        scorePaint2.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint2.setAntiAlias(true);



        avatarChoice = 0;

        //mmplayer get value to determine character...............
        avatarChoice = sp1Player.getCharacterDesign();


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

        seller = Bitmap.createScaledBitmap(unscaledseller, profileWidth, profileHeight, false);


        weatherselect = 0;

        int sp_weatherstate = sp1GameObject.getWeatherState();

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


        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledrecipepricing = BitmapFactory.decodeResource(getResources(), R.drawable.recipepricingbutton);
        recipepricingButton = Bitmap.createScaledBitmap(unscaledrecipepricing, rpWidth, rpHeight, false);

        unscaledstore = BitmapFactory.decodeResource(getResources(), R.drawable.storebutton);
        storeButton = Bitmap.createScaledBitmap(unscaledstore, storeWidth, storeHeight, false);




        unscaledemptyslot = BitmapFactory.decodeResource(getResources(), R.drawable.empty_icon);
        unscaledknife = BitmapFactory.decodeResource(getResources(), R.drawable.knife);
        unscaledcooler = BitmapFactory.decodeResource(getResources(), R.drawable.icecooler);

        player_string_inventory = sp1Player.getSelectedInvent();


        char invent1_choice = player_string_inventory.charAt(0);

        //slot1 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);


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

        //slot3 = Bitmap.createScaledBitmap(unscaledemptyslot, slot3Width, slot3Height, false);


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


        usave = BitmapFactory.decodeResource(getResources(), R.drawable.save_icon);
        save_icon = Bitmap.createScaledBitmap(usave, 500, 300, false);


        uexit = BitmapFactory.decodeResource(getResources(), R.drawable.exit_icon);
        exit_icon = Bitmap.createScaledBitmap(uexit, 500, 300, false);




        unscaledarrow = BitmapFactory.decodeResource(getResources(), R.drawable.goarrow);
        goarrow = Bitmap.createScaledBitmap(unscaledarrow, arrowWidth, arrowHeight, false);


        unscaledforecast = BitmapFactory.decodeResource(getResources(), R.drawable.forecast_icon);
        forecast = Bitmap.createScaledBitmap(unscaledforecast, forecastWidth, forecastHeight, false);


        unscaledlLcationImage = BitmapFactory.decodeResource(getResources(), R.drawable.location1);
        locationImage = Bitmap.createScaledBitmap(unscaledlLcationImage,  locationImageWidth, locationImageHeight, false);

        uinventmgment = BitmapFactory.decodeResource(getResources(), R.drawable.inventory_icon);
        inventmgmente = Bitmap.createScaledBitmap(uinventmgment, inventmgmtWidth, inventmgmtHeight, false);


        //unscaledserver = BitmapFactory.decodeResource(getResources(), R.drawable.changeservericon);
        //changeserverbutton = Bitmap.createScaledBitmap(unscaledserver, changeserverWidth, changeserverHeight, false);



    }

    /**
     * View onDraw Function
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        lemonstock = "Lemons: " + sp1GameObject.getLemons();
        waterstock = "Water: " + sp1GameObject.getWater();
        sugarstock = "Sugar: " + sp1GameObject.getSugar();


       s_Revenue = "Revenue/Total Return: $" + sp1GameObject.getRevenue();
       s_Overhead = "Overhead/Cost: $" + sp1GameObject.getOverhead();
       s_Profit = "Expected Profit: $" + sp1GameObject.getProfit();


        profileX = canvas.getWidth() - seller.getWidth() - 20;
        profileY = 20;

        canvas.drawBitmap(seller, profileX, profileY, null);


        locationImageX = (canvas.getWidth() /2 ) - (locationImageWidth/2);
        locationImageY = 20;
        canvas.drawBitmap(locationImage, locationImageX, locationImageY, null);



        canvas.drawBitmap(slot3, slot3X, slot3Y, null);
        canvas.drawBitmap(slot2, slot2X, slot2Y, null);
        canvas.drawBitmap(slot1, slot1X, slot1Y, null);


        canvas.drawText("PREVIOUS RETURN", 400, 750, scorePaint2);
        canvas.drawText(s_Revenue, 400, 850, scorePaint2);
        canvas.drawText(s_Overhead, 400, 950, scorePaint2);
        canvas.drawText(s_Profit, 400, 1050, scorePaint2);

        canvas.drawText("CURRENT STOCK", 400, 1200, scorePaint2);
        canvas.drawText(lemonstock, 400, 1300, scorePaint2);
        canvas.drawText(waterstock, 400, 1400, scorePaint2);
        canvas.drawText(sugarstock, 400, 1500, scorePaint2);


        //changeserverX = (canvas.getWidth()/2) - 100;
        //changeserverY = canvas.getHeight() - changeserverHeight - 20;
        //canvas.drawBitmap(changeserverbutton, changeserverX, changeserverY, null);


        canvas.drawBitmap(forecast, forecastX, forecastY, null);
        canvas.drawText(forecastString, 50, 1600, scorePaint2);



        int temp_text = sp1GameObject.getTemperature();

        int weathercheckstring = sp1GameObject.getWeatherState();
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




        canvas.drawText("" + weatherString, 430, 1650, scorePaint2);

        canvas.drawText("" + temp_text, 600, 1800, scorePaint2);
        canvas.drawBitmap(weathericon, weather_iconX, weather_iconY, null);




        arrowX = canvas.getWidth() - goarrow.getWidth() - 20;
        arrowY = canvas.getHeight() - goarrow.getHeight() - 20;
        canvas.drawBitmap(goarrow, arrowX, arrowY, null);


        canvas.drawBitmap(recipepricingButton, rpX, rpY, null);



        canvas.drawBitmap(storeButton, storeX, storeY, null);

        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);





        //inventory management screen
        if(showInventoryManagement)  {


            canvas.drawBitmap(inventmgmente, inventmgmtX, inventmgmtY, null);
            canvas.drawBitmap(exit_icon, 550, 1600, null);
            canvas.drawBitmap(save_icon, 50, 1600, null);



        }








    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if( x > rpX && x < rpX + rpWidth && y > rpY && y < rpY + rpHeight )  {

                    Toast.makeText(getContext(), "Go to Recipe/Pricing State", Toast.LENGTH_SHORT).show();
                    Intent intent_RP = new Intent(getContext(), RecipePricingActivity.class);
                    //intent_RP.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getContext().startActivity(intent_RP);

                }

                if( x > storeX && x < storeX + storeWidth && y > storeY && y < storeY + storeHeight )  {

                    Toast.makeText(getContext(), "store", Toast.LENGTH_SHORT).show();
                    Intent intent_RP = new Intent(getContext(), StoreActivity.class);
                    intent_RP.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getContext().startActivity(intent_RP);

                }


                // if touch the area where the items are
                if( x > slot1X && x < slot3X + slotWidth && y > slot1Y && y < slot3Y + slotHeight ) {

                    showInventoryManagement = true;

                }

                if(showInventoryManagement == true) {

                    //do actions here



                    //if save
                    if( x > 50 && x < 50 + 500 && y > 1600 && y < 1600 + 300 ) {

                        Toast.makeText(getContext(), "Saved!", Toast.LENGTH_SHORT).show();
                    }

                    // if exit
                    if( x > 550 && x < 550 + 500 && y > 1600 && y < 1600 + 300 ) {

                        showInventoryManagement = false;
                    }
                }


                if( x > arrowX && x < arrowX + arrowWidth && y > arrowY && y < arrowY + arrowHeight ) {
                    arrowClicked = true;

                    Toast.makeText(getContext(), "Start of the day", Toast.LENGTH_SHORT).show();
                    Intent intent_StartDay = new Intent(getContext(), SingleplayerActivity2.class);
                    intent_StartDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getContext().startActivity(intent_StartDay);

                }
                if( x > homeButtonX && x < homeButtonX + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {

                    Toast.makeText(getContext(), "Return to MainMenu", Toast.LENGTH_SHORT).show();
                    Intent intent_EndDay = new Intent(getContext(), MainMenuActivity.class);
                    intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    getContext().startActivity(intent_EndDay);

                }
                return true;
        }





        return false;
    }

}

