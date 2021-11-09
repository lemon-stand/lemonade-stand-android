package com.example.a219_lemonade_stand;
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

import java.util.Random;

public class SingleplayerView2 extends View {

    private Bitmap buyer[] = new Bitmap[2];
    private int buyerX;
    private int buyerY;
    private int buyerSpeed;
    private int buyerXStep;
    private int buyerYStep;

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

    private int gametime;
    private int hours;
    private int minutes;

    private String s_gametime = "";


    public int getgametime() {
        return gametime;
    }

    private String weathertext = "39\u00B0";


    private String lemonstock = "Lemons: 10";
    private String waterstock = "Water: 90";
    private String sugarstock = "Sugar: 30";

    private int money;



    public SingleplayerView2(Context context) {
        super(context);



        buyer[0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic1);
        buyer[1] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic2);

        unscaledbg = BitmapFactory.decodeResource(getResources(), R.drawable.location1);
        backgroundImage = Bitmap.createScaledBitmap(unscaledbg, 1000, 1600, false);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.lemonlogo);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledstall = BitmapFactory.decodeResource(getResources(), R.drawable.lemonadestandstall);
        stall = Bitmap.createScaledBitmap(unscaledstall, 300, 300, false);

        unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.sellerpic);
        seller = Bitmap.createScaledBitmap(unscaledseller, 300, 300, false);

        unscaledstockimage = BitmapFactory.decodeResource(getResources(), R.drawable.stockimage);
        stockimage = Bitmap.createScaledBitmap(unscaledstockimage, stockImageWidth, stockImageHeight, false);

        unscaledffbutton = BitmapFactory.decodeResource(getResources(), R.drawable.ffbuton);
        ffbutton = Bitmap.createScaledBitmap(unscaledffbutton, ffWidth, ffHeight, false);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        rainPaint.setColor(Color.CYAN);
        rainPaint.setAntiAlias(false);


        sellerX = 600;
        sellerY = 500;
        buyerX = 0;
        buyerY = 900;
        money = 0;
        gametime = 10000;

        hours = 9;
        minutes = 0;



    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        ffX = canvas.getWidth() - ffbutton.getWidth() - 20;
        ffY = canvas.getHeight() - ffbutton.getHeight() - 20;

        stockImageX =  20;
        stockImageY = canvas.getHeight() - ffbutton.getHeight() - 20;

        canvas.drawBitmap(stockimage, stockImageX, stockImageY, null);

        canvas.drawBitmap(backgroundImage, 0, 50, null);


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


        canvas.drawText("Money: " + money, (canvasWidth/2)- 400, 100 , scorePaint);
        canvas.drawText("Temp: " + weathertext, (canvasWidth/2), 200, scorePaint);
        canvas.drawText("Time: " + s_gametime , (canvasWidth/2), 100, scorePaint);

        canvas.drawText(lemonstock, stockImageX, stockImageY+50, scorePaint);
        canvas.drawText(waterstock, stockImageX, stockImageY+ 150, scorePaint);
        canvas.drawText(sugarstock, stockImageX, stockImageY + 250, scorePaint);

        canvas.drawBitmap(stall, 200, 500, null);
        canvas.drawBitmap(seller, sellerX, sellerY, null);

        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);
        canvas.drawBitmap(ffbutton, ffX, ffY, null);


        int minBuyerY = 300;
        int maxBuyerY = canvasHeight + buyer[0].getHeight();

        int minBuyerX = 0;
        int maxBuyerX = canvasWidth + buyer[0].getWidth();


        Random random=new Random();
        int number = random.nextInt(2 - -1) + -1;
        int number2 = random.nextInt(2 - -1) + -1;
        buyerSpeed = 3;

        buyerYStep = buyerYStep + buyerSpeed*number;
        buyerXStep = buyerXStep + buyerSpeed*number2;


        buyerY = buyerY + buyerYStep;

        buyerX = buyerX + buyerXStep;


        if(buyerY < minBuyerY){
            buyerY = maxBuyerY;
        }
        if(buyerY > maxBuyerY){
            buyerY = minBuyerY;
        }

        if(buyerX < minBuyerX){
            buyerX = maxBuyerX;
        }
        if(buyerX > maxBuyerX){
            buyerX = minBuyerX;
        }



        canvas.drawBitmap(buyer[0], buyerX,  buyerY,  null);

        if(touch)  {

            //canvas.drawBitmap(buyer[1], buyerX,  buyerY,  null);
            touch = false;
        }
        else {



        }
        if(customerpurchasechecker(sellerX, sellerY))
        {
            money = money +=10;
        }


        rainY = rainY - rainSpeed;
        if(rainY < 0) {
            rainY = canvasHeight + 21;
            rainX = (int) Math.floor(Math.random() * (canvasWidth - 0)) + 0;
        }

        canvas.drawLine(rainX, rainY, rainX+15, rainY+25, rainPaint);


        minutes++;
        gametime = gametime - 2;

        //if(gametime <= 0)

        if(hours >= 17)  {
            Toast.makeText(getContext(), "End of the day", Toast.LENGTH_SHORT).show();
            Intent intent_EndDay = new Intent(getContext(), SingleplayerActivity.class);
            intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            getContext().startActivity(intent_EndDay);


        }



    }

    public boolean customerpurchasechecker(int x, int y) {

        if(buyerX < x && x < (buyerX + buyer[0].getWidth()) && buyerY < y && y < (buyerY + buyer[0].getHeight())) {

            return true;
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
                if( x > homeButtonX && x < homeButtonY + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {

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

