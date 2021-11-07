package com.example.a219_lemonade_stand;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class SingleplayerView1 extends View {

    private Bitmap seller;

    public SingleplayerView1(Context context) {
        super(context);


        seller = BitmapFactory.decodeResource(getResources(), R.drawable.sellerpic);



    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvas.drawBitmap(seller, 0, 0, null);

    }
}

