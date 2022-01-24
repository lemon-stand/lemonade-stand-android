package com.example.a219_lemonade_stand.MenuSystem;

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

import com.example.a219_lemonade_stand.R;




public class MultiplayerMenuView extends View {

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;
    private int canvasWidth, canvasHeight;

    private Bitmap ulemonstandbg;
    private Bitmap lemonstandbg;

    private Paint scorePaint = new Paint();

    public MultiplayerMenuView(Context context) {
        super(context);

        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(lemonstandbg, 0, 0, null);

        canvas.drawText("Multiplayer Menu", 300, 200, scorePaint);
        canvas.drawText("Deets: server loc, rent status, go status?, total lvl-like info", 50, 400, scorePaint);


        canvas.drawText("Rent", 300, 800, scorePaint); // rent view
        canvas.drawText("Go", 300, 1200, scorePaint); // mp game view
        canvas.drawText("Hi-scores", 300, 1500, scorePaint); // hs view





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
                return true;
        }





        return false;
    }
}
