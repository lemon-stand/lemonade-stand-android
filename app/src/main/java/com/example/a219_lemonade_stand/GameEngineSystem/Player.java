package com.example.a219_lemonade_stand.GameEngineSystem;

import android.content.Context;
import android.util.Log;

import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Player {

    private long playerid =1;

    private long lemons;



    private long shiny_lemons;
    private long honey;
    private long sugar;
    private long water;
    private long money_balance;

    public long getID(){
        return playerid;
    }

    public long returnLemonStock() {

        return lemons;
    }

    public long getShiny_lemons() {
        return shiny_lemons;
    }

    public long getHoney() {
        return honey;
    }

    public long getSugar() {
        return sugar;
    }

    public long getWater() {
        return water;
    }
















    private static int int_characterDesign;


    public static String s_PlayerString = "NULL";
    public String getS_PString(){ return s_PlayerString; };


    public static String player_inventory = "KCZZZZZZZ";
    //public static String selected_inventory = "";
    public static String selected_inventory = player_inventory.substring(0, 3);

    public void setSelectedInvent(String _inventory) {
        selected_inventory = _inventory;
    }

    public String getSelectedInvent() {

        return selected_inventory;
    }

    public String getFullInvent() {
        return player_inventory;
    }
    private static String player_tuple = "";

    private static String chosenPlayerName = "";
    private static String chosenPlayerBalance = "";

    public void setChosenPlayerBalance(String _postTuple) {
        chosenPlayerBalance = _postTuple;
    }

    public void setChosenPlayerName(String _postTuple) {
        chosenPlayerName = _postTuple;
    }

    public void setChosenPlayerStock(long _lemons, long _shiny_lemons, long _honey, long _sugar, long _water){
        lemons = _lemons;
        shiny_lemons = _shiny_lemons;
        honey = _honey;
        sugar = _sugar;
        water = _water;
    }








    public String getPlayertuple() {


        return player_tuple;
    }







    public String s_getPlayerName(int _id) {

        _id = 1;


        return chosenPlayerName;
    }
    public String s_getPlayerBalance(int _id) {

        _id = 1;
        return  chosenPlayerBalance;
    }

    private static boolean connectionCheck = false;

    public boolean returnConnetionVariable() {


        if(connectionCheck) {
            return true;
        }


        return connectionCheck;
    }









    public Player() {


        //0 = bob , 1 james, 2 edna
        int_characterDesign =3;

        //k = knife, c= cooler, z = empty, a = adboard
        //player_inventory = "KCZZZZZZZ";
        //selected_inventory = player_inventory.substring(0, 3);
        


    }





    public int getCharacterDesign() {
     return int_characterDesign;
    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.player_profile_data);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                s_PlayerString = ret;
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void readPlayerFile() {


        //read file

        //file format: playerid_att (other files, playerid_log, playerid_server)
        //player_id(12),lemon8,sugar8,water8,money64
        //000000000000+00000000+00000000+00000000+0x64






    }










}







//////////
///
///
