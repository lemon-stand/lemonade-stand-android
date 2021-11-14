package com.example.a219_lemonade_stand;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class StoreView extends View {

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;

    private int iconSizeWidth = 300;
    private int iconSizeHeight = 400;

    private Bitmap lemonsIcon;
    private Bitmap unscaledlemons;
    private int lemonsX, lemonsY;

    private Bitmap sugarIcon;
    private Bitmap unscaledsugar;
    private int sugarX, sugarY;

    private Bitmap waterIcon;
    private Bitmap unscaledwater;
    private int waterX, waterY;



    private int canvasWidth, canvasHeight;

    public StoreView(Context context){
        super(context);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.lemonlogo);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        unscaledlemons = BitmapFactory.decodeResource(getResources(), R.drawable.lemons);
        lemonsIcon = Bitmap.createScaledBitmap(unscaledlemons, iconSizeWidth, iconSizeHeight, false);

        unscaledsugar = BitmapFactory.decodeResource(getResources(), R.drawable.sugar);
        sugarIcon = Bitmap.createScaledBitmap(unscaledsugar, iconSizeWidth, iconSizeHeight, false);

        unscaledwater = BitmapFactory.decodeResource(getResources(), R.drawable.water);
        waterIcon = Bitmap.createScaledBitmap(unscaledwater, iconSizeWidth, iconSizeHeight, false);





    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        lemonsX = 100;
        waterX = 400;
        sugarX = 700;

        lemonsY = (canvasHeight/2);
        sugarY = (canvasHeight/2);
        waterY = (canvasHeight/2);

        canvas.drawBitmap(lemonsIcon, lemonsX, lemonsY, null);
        canvas.drawBitmap(waterIcon, waterX, waterY, null);
        canvas.drawBitmap(sugarIcon, sugarX, sugarY, null);

        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if( x > homeButtonX && x < homeButtonY + homeButtonWidth && y > homeButtonY && y < homeButtonY + homeButtonHeight ) {

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
