package com.example.a219_lemonade_stand;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class SingleplayerView2 extends View {

    private Bitmap buyer[] = new Bitmap[2];
    private int buyerX = 10;
    private int buyerY;
    private int buyerspeed;

    private int canvasWidth, canvasHeight;


    private Bitmap backgroundImage;
    private Bitmap unscaledbg;

    private Paint scorePaint = new Paint();

    private String gametimetext = "1000";

    public SingleplayerView2(Context context) {
        super(context);



        buyer[0] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic1);
        buyer[1] = BitmapFactory.decodeResource(getResources(), R.drawable.buyerpic2);

        unscaledbg = BitmapFactory.decodeResource(getResources(), R.drawable.location1);

        backgroundImage = Bitmap.createScaledBitmap(unscaledbg, 600, 900, false);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);



    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();



        canvas.drawBitmap(backgroundImage, 0, 0, null);

        canvas.drawText("Time: ", 20, 60, scorePaint);

        canvas.drawText(gametimetext, 500, 60, scorePaint);


        int minBuyerY = buyer[0].getHeight();
        int maxBuyerY = canvasHeight - buyer[0].getHeight() + 3;

        buyerY = buyerY +buyerspeed;
        if(buyerY < minBuyerY){
            buyerY = minBuyerY;
        }
        if(buyerY < maxBuyerY){
            buyerY = maxBuyerY;
        }





    }
}

