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

import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.ServerDeets;
import com.example.a219_lemonade_stand.GameEngineSystem.GameObject;
import com.example.a219_lemonade_stand.GameEngineSystem.Player;
import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    private Bitmap shoppingcarticon;
    private Bitmap ushoppingcarticon;

    private Bitmap lemonsIcon;
    private Bitmap unscaledlemons;
    private int lemonsX, lemonsY;

    private Bitmap sugarIcon;
    private Bitmap unscaledsugar;
    private int sugarX, sugarY;

    private Bitmap waterIcon;
    private Bitmap unscaledwater;
    private int waterX, waterY;

    private String lemonstock = "Lemons: ";
    private String waterstock = "Water: ";
    private String sugarstock = "Sugar: ";

    private String intent_lemonstock = "Lemons: ";
    private String intent_waterstock = "Water: ";
    private String intent_sugarstock = "Sugar: ";

    GameObject storeGameObject = new GameObject();

    private Paint scorePaint = new Paint();
    private Paint scorePaint2 = new Paint();

    private int canvasWidth, canvasHeight;

    private int stockImageX, stockImageY, stockImageWidth = 300, stockImageHeight = 300;

    private Bitmap lemonstandbg, ulemonstandbg;

    private Player storePlayer = new Player();


    private String serverString = ServerDeets.IP_ADDRESS;

    private void getPostData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(serverString)

                //.baseUrl("localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //Post loginpost = new Post(username, password);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()) {
                    System.out.println("code:" + response.code());


                }

                List<Post> tempPost = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";

                for(Post post : tempPost) {

                    if(post.getName().equals(storePlayer.s_getPlayerName(1))){
                        //if(post.getName().equals(sp1Player.s_getPlayerName(1))){

                        storePlayer.setChosenPlayerName(storePlayer.s_getPlayerName(1));
                        storePlayer.setChosenPlayerBalance("" + post.getBalance());
                        storePlayer.setPlayer_ID(post.getId());
                        System.out.println("Balance print:" + post.getBalance());



                        storePlayer.setChosenPlayerStock(
                                post.getLemons(),
                                post.getShiny_lemons(),
                                post.getHoney(),
                                post.getSugar(),
                                post.getWater()
                        );
                    }

                }



            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {



            }
        });



    }


    public StoreView(Context context){

        super(context);

        getPostData();


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

        ushoppingcarticon = BitmapFactory.decodeResource(getResources(), R.drawable.shoppingcart_image);
        shoppingcarticon = Bitmap.createScaledBitmap(ushoppingcarticon, 400, 250, false);


        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        scorePaint2.setColor(Color.CYAN);
        scorePaint2.setTextSize(40);
        scorePaint2.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint2.setAntiAlias(true);

        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);



    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawBitmap(lemonstandbg, 0, 0, null);


        canvas.drawText("General Store", 300, 100, scorePaint);
        canvas.drawText("Balance: $" + storePlayer.s_getPlayerBalance(1), 300, 220, scorePaint2);
        canvas.drawText("Receipt: $" + (storeGameObject.getBalance()), 300, 280, scorePaint2);


        stockImageX =  20;
        stockImageY = canvas.getHeight() - 500 - 20;

        lemonstock = "Lemons: " + storePlayer.returnLemonStock();
        waterstock = "Water: " + storePlayer.getWater();
        sugarstock = "Sugar: " + storePlayer.getSugar();

        intent_lemonstock = "restocking: " +  storeGameObject.getLemons();
        intent_waterstock = "refilling: " +   storeGameObject.getWater();
        intent_sugarstock = "purchasing: " +  storeGameObject.getSugar();



        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        lemonsX = 100;
        waterX = 500;
        sugarX = 800;

        lemonsY = 400;
        sugarY =  400;
        waterY =  400;


        canvas.drawText("Fresh Lemons", lemonsX, lemonsY, scorePaint2);
        canvas.drawBitmap(lemonsIcon, lemonsX, lemonsY, null);

        canvas.drawBitmap(increment1b, i1bX, i1bY, null);
        canvas.drawBitmap(increment5b, i5bX, i5bY, null);


        canvas.drawText("Tap Water", waterX, waterY, scorePaint2);
        canvas.drawBitmap(waterIcon, waterX, waterY, null);

        canvas.drawBitmap(increment10b, i10bX, i10bY, null);
        canvas.drawBitmap(increment50b, i50bX, i50bY, null);


        canvas.drawText("Refined Sugar", sugarX, sugarY,  scorePaint2);
        canvas.drawBitmap(sugarIcon, sugarX, sugarY, null);

        canvas.drawBitmap(increment5b, i5bX2, i5bY, null);
        canvas.drawBitmap(increment10b, i10bX2, i10bY, null);

        canvas.drawText("Buy ingredients:", 100, 1700,  scorePaint);
        canvas.drawBitmap(shoppingcarticon, 600, 1650, null);

        canvas.drawText(lemonstock, stockImageX + 50, stockImageY    - 200 +50, scorePaint);
        canvas.drawText(waterstock, stockImageX + 50, stockImageY    - 200 + 150, scorePaint);
        canvas.drawText(sugarstock, stockImageX + 50, stockImageY    - 200  + 250, scorePaint);

        canvas.drawText(intent_lemonstock, stockImageX + 500, stockImageY-200  +20, scorePaint2);
        canvas.drawText(intent_waterstock, stockImageX + 500, stockImageY-200 + 120, scorePaint2);
        canvas.drawText(intent_sugarstock, stockImageX + 500, stockImageY-200  + 220, scorePaint2);

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


                //shopping cart / purchases button
                if( x > 600 && x < 600 + 400 && y > 1650 && y < 1650 + 250 ) {

                    Toast.makeText(getContext(), "Sending post to purchase", Toast.LENGTH_SHORT).show();





                    System.out.println("printing: l" +  storeGameObject.getLemons() );
                    System.out.println("printing: w" +  storeGameObject.getWater() );
                    System.out.println("printing: s" +  storeGameObject.getSugar() );
                    System.out.println("printing: b" + storeGameObject.getBalance());

                    /// save new values


                    //send postdata method




                    storeGameObject.setLemons(0);
                    storeGameObject.setSugar(0);
                    storeGameObject.setWater(0);
                    storeGameObject.setBalance(0);

                }



                return true;
        }





        return false;
    }

}
