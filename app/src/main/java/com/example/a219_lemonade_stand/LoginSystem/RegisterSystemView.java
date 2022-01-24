package com.example.a219_lemonade_stand.LoginSystem;

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

public class RegisterSystemView extends View {

    private Bitmap ulemonstandbg;
    private Bitmap lemonstandbg;

    private Bitmap backbutton;
    private Bitmap unscaledhome;
    private int backbuttonX = 20, backbuttonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;
    private int canvasWidth, canvasHeight;

    private Bitmap uregisterIcon;
    private Bitmap registerIcon;
    private int registerIconX = 200, registerIconY = 100, registerIconWidth = 400, registerIconHeight = 300;

    private Paint scorePaint = new Paint();

    public RegisterSystemView(Context context) {
        super(context);

        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.backbutton);
        backbutton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);

        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);

        uregisterIcon = BitmapFactory.decodeResource(getResources(), R.drawable.registeruser_icon);
        registerIcon = Bitmap.createScaledBitmap(uregisterIcon, registerIconWidth, registerIconHeight, false);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        canvas.drawBitmap(lemonstandbg, 0, 0, null);
        canvas.drawBitmap(registerIcon, registerIconX, registerIconY, null);

        canvas.drawText("Register Account", 600, 200, scorePaint);
        //canvas.drawText("allow of registering accounts, submit button, unique para check", 200, 250, scorePaint);


        canvas.drawText("fullname", 300, 500, scorePaint);
        canvas.drawText("username", 300, 700, scorePaint);
        canvas.drawText("dob", 300, 900, scorePaint);


        canvas.drawText("email", 300, 1100, scorePaint);
        canvas.drawText("confirm email", 300, 1300, scorePaint);
        canvas.drawText("password", 300, 1500, scorePaint);
        canvas.drawText("confirm password", 300, 1700, scorePaint);
        canvas.drawText("captcha?", 300, 1900, scorePaint);

        //email confirm before full account creation

        canvas.drawBitmap(backbutton, backbuttonX, backbuttonY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:


                if( x > backbuttonX && x < backbuttonX + homeButtonWidth && y > backbuttonY && y < backbuttonY + homeButtonHeight ) {

                    Intent intent_EndDay = new Intent(getContext(), LoginSystemActivity.class);
                    //intent_EndDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    getContext().startActivity(intent_EndDay);

                }
                return true;
        }





        return false;
    }


}