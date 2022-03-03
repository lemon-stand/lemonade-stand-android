package com.example.a219_lemonade_stand.GameEngineSystem;

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
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.ServerDetails;
import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InventoryView extends View {

    private Bitmap homeButton;
    private Bitmap unscaledhome;
    private int homeButtonX = 20, homeButtonY = 20, homeButtonWidth = 200, homeButtonHeight = 200;

    private Bitmap lemonstandbg, ulemonstandbg;

    private Paint scorePaint = new Paint();

    Player ivPlayer = new Player();

    private String player_string_inventory ="";
    private String player_string_fullinventory ="";

    private int slot_size = 200;

    private Bitmap slot1;
    private int slot1X = 150, slot1Y = 1000;

    private Bitmap slot2;
    private int slot2X = 500, slot2Y = 1000;

    private Bitmap slot3;
    private int slot3X = 800, slot3Y = 1000;


    private Bitmap slot4;
    private int slot4X = 150, slot4Y = 1400;

    private Bitmap slot5;
    private int slot5X = 500, slot5Y = 1400;

    private Bitmap slot6;
    private int slot6X = 800, slot6Y = 1400;



    private Bitmap unscaledknife;
    private Bitmap unscaledcooler;

    private Bitmap emptyslot;
    private Bitmap unscaledemptyslot;

    private Bitmap selectedbmap, uselectedbmap;
    private int selectslotsize = 250;
    private int selectedbmapicon_x1 = 0, selectedbmapicon_y1 = 0;
    private int selectedbmapicon_x3 = 0, selectedbmapicon_y3 = 0;
    private int selectedbmapicon_x2 = 0, selectedbmapicon_y2 = 0;

    Boolean select1= false, select2 = false, select3 = false;

    private static String newSelect = "";

    public InventoryView(Context context) {
        super(context);

        getPostData();

        scorePaint.setColor(Color.CYAN);
        scorePaint.setTextSize(65);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        unscaledhome = BitmapFactory.decodeResource(getResources(), R.drawable.homebutton);
        homeButton = Bitmap.createScaledBitmap(unscaledhome, homeButtonWidth, homeButtonHeight, false);
        ulemonstandbg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        lemonstandbg = Bitmap.createScaledBitmap(ulemonstandbg, 1100, 2000, false);

        unscaledemptyslot = BitmapFactory.decodeResource(getResources(), R.drawable.empty_icon);
        unscaledknife = BitmapFactory.decodeResource(getResources(), R.drawable.knife);
        unscaledcooler = BitmapFactory.decodeResource(getResources(), R.drawable.icecooler);

        player_string_inventory = ivPlayer.getSelectedInvent();
        player_string_fullinventory = ivPlayer.getFullInvent();

        uselectedbmap = BitmapFactory.decodeResource(getResources(), R.drawable.selectedpng);
        selectedbmap = Bitmap.createScaledBitmap(uselectedbmap,selectslotsize , selectslotsize, false);


        char invent1_choice = player_string_fullinventory.charAt(0);

        //slot1 = Bitmap.createScaledBitmap(unscaledemptyslot, slotWidth, slotHeight, false);


        switch(invent1_choice) {
            case 'K':
                slot1 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot1 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot1 = Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }


        char invent2_choice = player_string_fullinventory.charAt(1);

        switch(invent2_choice) {
            case 'K':
                slot2 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot2 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot2 = Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }


        char invent3_choice = player_string_fullinventory.charAt(2);


        switch(invent3_choice) {
            case 'K':
                slot3 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot3 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot3= Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }


        switch(player_string_fullinventory.charAt(3)) {
            case 'K':
                slot4 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot4 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot4= Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }


        switch(player_string_fullinventory.charAt(4)) {
            case 'K':
                slot5 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot5 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot5= Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }

        switch(player_string_fullinventory.charAt(5)) {
            case 'K':
                slot6 = Bitmap.createScaledBitmap(unscaledknife, slot_size, slot_size, false);
                break;
            case 'Z':
                slot6 = Bitmap.createScaledBitmap(unscaledemptyslot, slot_size, slot_size, false);
                break;
            case 'C':
                slot6= Bitmap.createScaledBitmap(unscaledcooler, slot_size, slot_size, false);
                break;

        }










    }

    private String serverString = ServerDetails.IP_ADDRESS;


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

                    if(post.getName().equals(ivPlayer.s_getPlayerName(1))){
                        //if(post.getName().equals(sp1Player.s_getPlayerName(1))){

                        ivPlayer.setChosenPlayerName(ivPlayer.s_getPlayerName(1));
                        ivPlayer.setChosenPlayerBalance("" + post.getBalance());
                        ivPlayer.setPlayer_ID(post.getId());
                        System.out.println("Balance print:" + post.getBalance());



                        ivPlayer.setChosenPlayerStock(
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



        canvas.drawBitmap(lemonstandbg, 0, 0, null);
        canvas.drawBitmap(homeButton, homeButtonX, homeButtonY, null);

        canvas.drawBitmap(selectedbmap, slot1X - 30, slot1Y - 30, null);
        canvas.drawBitmap(selectedbmap, slot2X - 30, slot2Y - 30, null);
        canvas.drawBitmap(selectedbmap, slot3X - 30, slot3Y - 30, null);


        canvas.drawBitmap(slot1, slot1X, slot1Y, null);
        canvas.drawBitmap(slot2, slot2X, slot2Y, null);
        canvas.drawBitmap(slot3, slot3X, slot3Y, null);

        canvas.drawBitmap(slot4, slot4X, slot4Y, null);
        canvas.drawBitmap(slot5, slot5X, slot5Y, null);
        canvas.drawBitmap(slot6, slot6X, slot6Y, null);



        canvas.drawText("Inventory Management",300, 100, scorePaint);
        canvas.drawText("Balance: $" + ivPlayer.s_getPlayerBalance(1),350, 250, scorePaint);
        canvas.drawText("Stock: ",100, 400, scorePaint);
        canvas.drawText("Shiny Lemons: " + ivPlayer.getShiny_lemons(),200, 500, scorePaint);
        canvas.drawText("Lemons: " + ivPlayer.returnLemonStock(),200, 580, scorePaint);
        canvas.drawText("Sugar: " + ivPlayer.getSugar(),200, 660, scorePaint);
        canvas.drawText("Honey: " + ivPlayer.getHoney(),200, 740, scorePaint);
        canvas.drawText("Water: " + ivPlayer.getWater(),200, 820, scorePaint);

        canvas.drawText("Items: ",100, 950, scorePaint);

        canvas.drawText("[Change Inventory Order]",200, 1800, scorePaint);      //TODO implement this
        //canvas.drawText("[Botany Lab]",200, 1700, scorePaint);
        //canvas.drawText("[Player Farm]",200, 1800, scorePaint);
        //canvas.drawText("[Business Manufacturing]",200, 1900, scorePaint); //selling a lot of lemons or mass production

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

                if( x > 50 && x < 50 + 1300 && y > 1600 && y < 1600 + 500 ) {

                    Toast.makeText(getContext(), "Change inventory order under construction", Toast.LENGTH_SHORT).show();
                }


                return true;
        }





        return false;
    }

}
