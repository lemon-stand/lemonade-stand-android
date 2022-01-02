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

import com.example.a219_lemonade_stand.GameEngineSystem.GameObject;
import com.example.a219_lemonade_stand.MainmenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

public class StoreView extends View {

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;


    private Bitmap increment1b;
    private Bitmap unscaledi1;
    private int i1bX = 50, i1bY = 700, i1bWidth = 100, i1bHeight = 100;

    private Bitmap increment5b;
    private Bitmap unscaledi5;
    private int i5bX = 200, i5bX2 =750, i5bY = 700, i5bWidth = 100, i5bHeight = 100;

    private Bitmap increment10b;
    private Bitmap unscaledi10;
    private int i10bX = 400, i10bX2 = 900, i10bY = 700, i10bWidth = 100, i10bHeight = 100;

    private Bitmap increment50b;
    private Bitmap unscaledi50;
    private int i50bX = 600, i50bY = 700, i50bWidth = 100, i50bHeight = 100;

    private int iconSizeWidth = 150;
    private int iconSizeHeight = 200;

    private Bitmap lemonsIcon;
    private Bitmap unscaledlemons;
    private int lemonsX, lemonsY;

    private Bitmap sugarIcon;
    private Bitmap unscaledsugar;
    private int sugarX, sugarY;

    private Bitmap waterIcon;
    private Bitmap unscaledwater;
    private int waterX, waterY;

    private String lemonstock = "Lemons: 10";
    private String waterstock = "Water: 90";
    private String sugarstock = "Sugar: 30";

    GameObject storeGameObject = new GameObject();

    private Paint scorePaint = new Paint();

    private int canvasWidth, canvasHeight;

    private int stockImageX, stockImageY, stockImageWidth = 300, stockImageHeight = 300;

    private Bitmap lemonstandbg, ulemonstandbg;

    public StoreView(Context context){
        super(context);



        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledlemons = BitmapFactory.decodeResource(getResources(), R.drawable.lemons);
        lemonsIcon = Bitmap.createScaledBitmap(unscaledlemons, iconSizeWidth, iconSizeHeight, false);

        unscaledsugar = BitmapFactory.decodeResource(getResources(), R.drawable.sugar);
        sugarIcon = Bitmap.createScaledBitmap(unscaledsugar, iconSizeWidth, iconSizeHeight, false);

        unscaledwater = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        waterIcon = Bitmap.createScaledBitmap(unscaledwater, iconSizeWidth, iconSizeHeight, false);

        unscaledi1 = BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon);
        increment1b = Bitmap.createScaledBitmap(unscaledi1, i1bWidth, i1bHeight, false);

        unscaledi5 = BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon5);
        increment5b = Bitmap.createScaledBitmap(unscaledi5, i5bWidth, i5bHeight, false);

        unscaledi10 = BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon10);
        increment10b = Bitmap.createScaledBitmap(unscaledi10, i10bWidth, i10bHeight, false);

        unscaledi50 = BitmapFactory.decodeResource(getResources(), R.drawable.plus_icon50);
        increment50b = Bitmap.createScaledBitmap(unscaledi50, i50bWidth, i50bHeight, false);


        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);



    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawBitmap(lemonstandbg, 0, 0, null);

        canvas.drawText("Balance: $xxx", (canvasWidth/2) -200, 100, scorePaint);

        stockImageX =  20;
        stockImageY = canvas.getHeight() - 500 - 20;

        lemonstock = "Lemons: " + storeGameObject.getLemons();
        waterstock = "Water: " + storeGameObject.getWater();
        sugarstock = "Sugar: " + storeGameObject.getSugar();

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        lemonsX = 100;
        waterX = 500;
        sugarX = 800;

        lemonsY = 500;
        sugarY =  500;
        waterY =  500;


        canvas.drawText("Fresh lemons", lemonsX, lemonsY, scorePaint);
        canvas.drawBitmap(lemonsIcon, lemonsX, lemonsY, null);

        canvas.drawBitmap(increment1b, i1bX, i1bY, null);
        canvas.drawBitmap(increment5b, i5bX, i5bY, null);


        canvas.drawText("Tap water", waterX, waterY, scorePaint);
        canvas.drawBitmap(waterIcon, waterX, waterY, null);

        canvas.drawBitmap(increment10b, i10bX, i10bY, null);
        canvas.drawBitmap(increment50b, i50bX, i50bY, null);


        canvas.drawText("Honey", sugarX, sugarY,  scorePaint);
        canvas.drawBitmap(sugarIcon, sugarX, sugarY, null);

        canvas.drawBitmap(increment5b, i5bX2, i5bY, null);
        canvas.drawBitmap(increment10b, i10bX2, i10bY, null);



        canvas.drawText(lemonstock, stockImageX, stockImageY+50, scorePaint);
        canvas.drawText(waterstock, stockImageX, stockImageY+ 150, scorePaint);
        canvas.drawText(sugarstock, stockImageX, stockImageY + 250, scorePaint);

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
                    intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    getContext().startActivity(intent_EndDay);

                }

                if( x > lemonsX && x < lemonsX + stockImageWidth && y > lemonsY && y < lemonsY + stockImageHeight ) {

                    storeGameObject.buyLemons();

                }

                if( x > sugarX && x < sugarX + stockImageWidth && y > sugarY && y < sugarY + stockImageHeight ) {

                    storeGameObject.buySugar();

                }

                if( x > waterX && x < waterX + stockImageWidth && y > waterY && y < waterY + stockImageHeight ) {

                    storeGameObject.buyWater();

                }



                return true;
        }





        return false;
    }

}
