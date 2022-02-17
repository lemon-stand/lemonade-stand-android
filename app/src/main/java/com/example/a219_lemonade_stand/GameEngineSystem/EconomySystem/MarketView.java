package com.example.a219_lemonade_stand.GameEngineSystem.EconomySystem;

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

import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

public class MarketView extends View {

    private Bitmap ulemonstandbg;
    private Bitmap lemonstandbg;

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;
    private int canvasWidth, canvasHeight;

    private Bitmap tradingicon;
    private Bitmap utradingicon;
    private int tradingiconX = 700, tradingiconY = 1600, tradingiconWidth = 300, tradingiconHeight = 300;




    private Paint scorePaint = new Paint();


    public MarketView(Context context) {
        super(context);


        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);

        utradingicon = BitmapFactory.decodeResource(getResources(), R.drawable.trading_icon);
        tradingicon = Bitmap.createScaledBitmap(utradingicon, tradingiconWidth, tradingiconHeight, false);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

       canvas.drawBitmap(lemonstandbg, 0, 0, null);

        canvas.drawText("Market Exchange", 300, 100, scorePaint);

        canvas.drawText("Market Slot 1", 100, 400, scorePaint);
        canvas.drawText("Market Slot 2", 100, 800, scorePaint);
        canvas.drawText("Market Slot 3", 100, 1200, scorePaint);


        canvas.drawText("Chat window", 100, 1500, scorePaint);
        canvas.drawText("Trades", 700, 1500, scorePaint);


        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);

        canvas.drawBitmap(tradingicon, tradingiconX, tradingiconY, null);


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
                if( x > tradingiconX && x < tradingiconX + tradingiconWidth && y > tradingiconY && y < tradingiconY + tradingiconHeight ) {

                    Intent intent_EndDay = new Intent(getContext(), TradingActivity.class);
                    //intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    getContext().startActivity(intent_EndDay);

                }



                return true;
        }





        return false;
    }


}
