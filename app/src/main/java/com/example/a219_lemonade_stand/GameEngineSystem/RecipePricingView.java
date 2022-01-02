package com.example.a219_lemonade_stand.GameEngineSystem;

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

import com.example.a219_lemonade_stand.GameEngineSystem.GameObject;
import com.example.a219_lemonade_stand.MainmenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

public class RecipePricingView extends View {



    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;

    private int canvasWidth, canvasHeight;

    private int decrementX = 100;
    private int decrementY = 0;

    private int incrementX = (canvasWidth/2) + 900;
    private int incrementY = 0;

    private int changebuttonheight = 100;
    private int changebuttonwidth = 100;



    private Bitmap decrementButton;
    private Bitmap unscaledDecrement;

    private Bitmap incrementButton;
    private Bitmap unscaledIncrement;

    private String s_currentBalance = "";
    private String s_PricingPerCup = "";

    private int dec_pricingpercup_x = 100;
    private int dec_pricingpercup_y = 300;

    private int inc_pricingpercup_x = 900;
    private int inc_pricingpercup_y = 300;



    private String s_profitwrecipe = "";
    private String s_recipecost = "";
    private double playerbalance = 0;
    private double pricingpcup = 0;
    private double profitwrecip = 0;
    private double recipecost = 0;



    private String s_lemonsPerCup = "";

    private int dec_lemonsPerCup_X = 100;
    private int dec_lemonsPercup_Y = 1000;

    private int inc_lemomnsPerCup_X = 900;
    private int inc_lemonsPerCup_Y = 1000;


    private String s_sugarPerCup = "";

    private int dec_sugarPerCup_x = 100;
    private int dec_sugarPerCup_y = 1200;

    private int inc_sugarPerCup_x = 900;
    private int inc_sugarPerCup_y = 1200;

    private String s_waterPerCup = "";

    private int dec_waterPerCup_x = 100;
    private int dec_waterPerCup_y = 1400;

    private int inc_waterPerCup_x = 900;
    private int inc_waterPerCup_y = 1400;

    private int lemonspcup = 0;
    private int sugarpercup = 0;
    private int waterpercup = 0;

    private String s_flavours = "";
    private String s_effects = "";

    private Paint scorePaint = new Paint();
    private Paint flavorPaint = new Paint();

    GameObject recipePricingGameObject = new GameObject();

    private Bitmap lemonstandbg, ulemonstandbg;

    public RecipePricingView(Context context) {
        super(context);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledDecrement = BitmapFactory.decodeResource(getResources(), R.drawable.minus_icon);
        decrementButton = Bitmap.createScaledBitmap(unscaledDecrement, 100, 100, false);

        unscaledIncrement = BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon);
        incrementButton = Bitmap.createScaledBitmap(unscaledIncrement, 100, 100, false);

        s_currentBalance = "" + recipePricingGameObject.getBalance();


        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);

        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        flavorPaint.setColor(Color.CYAN);
        flavorPaint.setTextSize(30);
        flavorPaint.setTypeface(Typeface.DEFAULT_BOLD);
        flavorPaint.setAntiAlias(true);





    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(lemonstandbg, 0, 0, null);






        ////
        ///     show slots

        ////






        //player balance
        playerbalance = recipePricingGameObject.getBalance();
        s_currentBalance = " " + playerbalance;
        canvas.drawText("Balance: $" + s_currentBalance, (canvasWidth/2) -200, 100, scorePaint);




        canvas.drawText("PRICING",(canvasWidth/2), 200, scorePaint);

        //pricing per cup text
        pricingpcup = recipePricingGameObject.getPPC();
        s_PricingPerCup = "$" + pricingpcup + " per cup:: ";
        canvas.drawText(s_PricingPerCup, (canvasWidth/2) -250, 400, scorePaint);

        //Pricing per cup buttons
        canvas.drawBitmap(decrementButton, dec_pricingpercup_x, dec_pricingpercup_y, null);
        canvas.drawBitmap(incrementButton,  inc_pricingpercup_x, inc_pricingpercup_y, null);


        //profit with recipe text
        profitwrecip = recipePricingGameObject.getrecipeprofit();
        s_profitwrecipe = "Profit w/ Recipe: $" + profitwrecip;
        canvas.drawText(s_profitwrecipe, (canvasWidth/2) -400, 600, scorePaint);

        //recipe cost text
        recipecost = recipePricingGameObject.getrecipecost();
        s_recipecost = "Recipe cost per cup: $" + recipecost;
        canvas.drawText(s_recipecost, (canvasWidth/2) -400, 800, scorePaint);





        s_flavours = "Flavour: q"; //sweet normal
        s_effects = "Effect: q";    //happy normal


        int forumla;
        double waterportion, sugarportion, lemonsportion;

        forumla = ( (int) recipePricingGameObject.getUseLemons() + recipePricingGameObject.getUseSugar() + (recipePricingGameObject.getUseWater() /10) );

        waterportion = (recipePricingGameObject.getUseWater()) / forumla  ;
        sugarportion  = recipePricingGameObject.getUseSugar() / forumla ;
        lemonsportion  = recipePricingGameObject.getUseLemons() / forumla ;


        if( waterportion == 0.5) {
            s_flavours = " Normal ";
            s_effects = " Normal ";
        }

         if( waterportion > 0.6) {
            s_flavours = " Watery ";
            s_effects = "Refreshed ";
        }
         if( waterportion < 0.4) {
            s_flavours = " Dry ";
            s_effects = " Cheated ";
        }

         if( sugarportion > 0.6) {
            s_flavours = " Sweet ";
            s_effects = " Regenerated ";
        }
         if( sugarportion < 0.4) {
            s_flavours = " Dry ";
            s_effects = " Cheated ";
        }

         if( sugarportion == 0.5) {
            s_flavours = " Normal ";
            s_effects = " Normal ";
        }

         if( lemonsportion > 0.6) {
            s_flavours = " Great ";
            s_effects = " Rejuvenated ";
        }
         if( lemonsportion < 0.4) {
            s_flavours = " Flavourless ";
            s_effects = " Okay ";
        }

         if( sugarportion == 0.5) {
            s_flavours = " Normal ";
            s_effects = " Normal ";
        }

















        canvas.drawText("RECIPE",(canvasWidth/2), 1000, scorePaint);

        //flavour and effects

        canvas.drawText(s_flavours, (canvasWidth/2) -450, 1800, flavorPaint);
        canvas.drawText(s_effects, (canvasWidth/2) +50, 1800, flavorPaint);


        // lemons per cup buttons, text
        lemonspcup = (int) recipePricingGameObject.getUseLemons();
        s_lemonsPerCup = lemonspcup + " Lemons Per Cup";
        canvas.drawText(s_lemonsPerCup, (canvasWidth/2) -250, 1100, scorePaint);
        canvas.drawBitmap(decrementButton, dec_lemonsPerCup_X, dec_lemonsPercup_Y, null);
        canvas.drawBitmap(incrementButton, inc_lemomnsPerCup_X, inc_lemonsPerCup_Y, null);


        //  sugar per cup buttons, text
        sugarpercup = recipePricingGameObject.getUseSugar();
        s_sugarPerCup = sugarpercup + "g sugar per cup";
        canvas.drawText(s_sugarPerCup, (canvasWidth/2) -250, 1300, scorePaint);
        canvas.drawBitmap(decrementButton, dec_sugarPerCup_x, dec_sugarPerCup_y, null);
        canvas.drawBitmap(incrementButton, inc_sugarPerCup_x, inc_sugarPerCup_y, null);

        //water per cup buttons, text
        waterpercup = recipePricingGameObject.getUseWater();
        s_waterPerCup = waterpercup + "ml water per cup";
        canvas.drawText(s_waterPerCup, (canvasWidth/2) -250, 1500, scorePaint);
        canvas.drawBitmap(decrementButton, dec_waterPerCup_x, dec_waterPerCup_y, null);
        canvas.drawBitmap(incrementButton, inc_waterPerCup_x, inc_waterPerCup_y, null);


        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();


        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if( x > homeButtonX && x < homeButtonX + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {

                    Toast.makeText(getContext(), "Return to MainMenu", Toast.LENGTH_SHORT).show();
                    Intent intent_EndDay = new Intent(getContext(), MainMenuActivity.class);
                    //intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    getContext().startActivity(intent_EndDay);

                }

                if( x > dec_pricingpercup_x && x < dec_pricingpercup_x + changebuttonwidth && y > dec_pricingpercup_y && y < dec_pricingpercup_y + changebuttonheight ) {

                    recipePricingGameObject.dodecrement();

                }

                if( x > inc_pricingpercup_x && x < inc_pricingpercup_x + changebuttonwidth && y > inc_pricingpercup_y && y < inc_pricingpercup_y + changebuttonheight ) {

                    recipePricingGameObject.doincrement();

                }

                if( x > dec_lemonsPerCup_X && x < dec_lemonsPerCup_X + changebuttonwidth && y > dec_lemonsPercup_Y && y < dec_lemonsPercup_Y + changebuttonheight ) {

                    recipePricingGameObject.changeUseLemons(-1);

                }

                if( x > inc_lemomnsPerCup_X && x < inc_lemomnsPerCup_X + changebuttonwidth && y > inc_lemonsPerCup_Y && y < inc_lemonsPerCup_Y + changebuttonheight ) {

                    recipePricingGameObject.changeUseLemons(+1);

                }
                if( x > dec_sugarPerCup_x && x < dec_sugarPerCup_x + changebuttonwidth && y > dec_sugarPerCup_y && y < dec_sugarPerCup_y + changebuttonheight ) {

                    recipePricingGameObject.changeUseSugar(-1);

                }

                if( x > inc_sugarPerCup_x && x < inc_sugarPerCup_x + changebuttonwidth && y > inc_sugarPerCup_y && y < inc_sugarPerCup_y + changebuttonheight ) {

                    recipePricingGameObject.changeUseSugar(+1);

                }

                if( x > dec_waterPerCup_x && x < dec_waterPerCup_x + changebuttonwidth && y > dec_waterPerCup_y && y < dec_waterPerCup_y + changebuttonheight ) {

                    recipePricingGameObject.changeUseWater(-4);

                }

                if( x > inc_waterPerCup_x && x < inc_waterPerCup_x + changebuttonwidth && y > inc_waterPerCup_y && y < inc_waterPerCup_y + changebuttonheight ) {

                    recipePricingGameObject.changeUseWater(+4);

                }






                return true;
        }





        return false;
    }


}
