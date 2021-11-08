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
import android.widget.ImageButton;
import android.widget.Toast;

public class SingleplayerView1 extends View {

    private Bitmap seller;
    private Bitmap unscaledseller;
    private String lemonstock = "lemons: ";
    private String waterstock = "water: ";
    private String sugarstock = "sugar: ";

    private String s_Revenue = "Revenue: ";
    private String s_Overhead = "Overhead: ";
    private String s_Profit = "Profit: ";

    private Paint scorePaint = new Paint();


    private Bitmap locationImage;
    private Bitmap unscaledlLcationImage;


    private Bitmap unscaledknife;
    private Bitmap knife;

    private Bitmap unscaledcooler;
    private Bitmap cooler;


    private int arrowX = 700, arrowY = 900, arrowWidth = 300, arrowHeight = 700;
    private Bitmap unscaledarrow;
    private Bitmap goarrow;
    private boolean arrowClicked= false;
    public int prevmoney;

    public boolean getarrowClicked() { return arrowClicked; };





    private boolean touch = false;

    public SingleplayerView1(Context context) {
        super(context);



        unscaledknife = BitmapFactory.decodeResource(getResources(), R.drawable.knife);
        knife = Bitmap.createScaledBitmap(unscaledknife, 300, 300, false);

        unscaledcooler = BitmapFactory.decodeResource(getResources(), R.drawable.icecooler);
        cooler = Bitmap.createScaledBitmap(unscaledcooler, 300, 300, false);


        unscaledseller = BitmapFactory.decodeResource(getResources(), R.drawable.sellerpic);
        seller = Bitmap.createScaledBitmap(unscaledseller, 300, 300, false);


        unscaledarrow = BitmapFactory.decodeResource(getResources(), R.drawable.goarrow);
        goarrow = Bitmap.createScaledBitmap(unscaledarrow, arrowWidth, arrowHeight, false);



        unscaledlLcationImage = BitmapFactory.decodeResource(getResources(), R.drawable.location1);
        locationImage = Bitmap.createScaledBitmap(unscaledlLcationImage,  400, 300, false);



        scorePaint.setColor(Color.MAGENTA);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);





    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawBitmap(seller, 0, 50, null);
        canvas.drawBitmap(locationImage, 0, 500, null);

        canvas.drawBitmap(cooler, 400, 500, null);
        canvas.drawBitmap(knife, 800, 500, null);

        canvas.drawText(lemonstock, 500, 70, scorePaint);
        canvas.drawText(waterstock, 500, 270, scorePaint);
        canvas.drawText(sugarstock, 500, 470, scorePaint);

        canvas.drawText(s_Revenue, 20, 700, scorePaint);
        canvas.drawText(s_Overhead, 20, 900, scorePaint);
        canvas.drawText(s_Profit, 20, 1100, scorePaint);

        canvas.drawBitmap(goarrow, arrowX, arrowY, null);


        if(touch)  {


        }
        else {



        }





    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if( x > arrowX && x < arrowX + arrowWidth && y > arrowY && y < arrowY + arrowHeight ) {
                    arrowClicked = true;

                    Toast.makeText(getContext(), "Start of the day", Toast.LENGTH_SHORT).show();
                    Intent intent_StartDay = new Intent(getContext(), SingleplayerActivity2.class);
                    intent_StartDay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getContext().startActivity(intent_StartDay);

                }
                return true;
        }





        return false;
    }

}

