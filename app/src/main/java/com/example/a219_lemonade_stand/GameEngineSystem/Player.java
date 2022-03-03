package com.example.a219_lemonade_stand.GameEngineSystem;

import android.content.Context;
import android.util.Log;

import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.JsonPlaceHolderApi;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.Post;
import com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem.ServerDetails;
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


/**
 * Player Class that contains the storage for the player
 *
 * able to hold the stock, (ordered) inventory of the player
 * able to set new stock values or new ordered inventory
 *
 * Designed to be used throughout the system to retrieve and define new data.
 *
 */
public class Player {

    private String serverString = ServerDetails.IP_ADDRESS;

    /**
     * Player attritbutes
     */
    private long playerid = 0;

    private long lemons;
    private long shiny_lemons;
    private long honey;
    private long sugar;
    private long water;
    private long money_balance;


    /**
     *  Player getter methods to return specific attributes
     *
     * @return
     */

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


    /**
     * Setters code for setting specific player attribute values and variables
     */

    public void setPlayer_ID(long _id) {
        playerid = _id;
    }


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


    private static String bufferplayername = "Bob"; //bob for test reasons



    public String s_getPlayerName(int _id) {

        _id = 1;


        return chosenPlayerName;
    }
    public String s_getPlayerBalance(int _id) {

        _id = 1;
        return  chosenPlayerBalance;
    }


    /**
     * Potentially unused networking connection code
     */
    private static boolean connectionCheck = false;

    public boolean returnConnetionVariable() {


        if(connectionCheck) {
            return true;
        }


        return connectionCheck;
    }


    /**
     *  Player Class Constructor
     *
     *
     *
     */
    public Player() {

        if(chosenPlayerName.isEmpty()){
            chosenPlayerName = bufferplayername;
        }


        if(chosenPlayerName.isEmpty()){
            chosenPlayerName = "Bob"; playerid = 5;
        }

        //0 = bob , 1 james, 2 edna
        int_characterDesign = 1;    //default user

        if((chosenPlayerName.equals("admin")) || (chosenPlayerName.equals("Admin")) ){
            setChosenPlayerBalance("999999999");
            int_characterDesign = 2;
        }

        if(chosenPlayerName.equals("Bob")) {
            int_characterDesign = 0;
        }

        //k = knife, c= cooler, z = empty, a = adboard
        //player_inventory = "KCZZZZZZZ";
        //selected_inventory = player_inventory.substring(0, 3);

        bufferplayername = chosenPlayerName;

    }

    private static int int_characterDesign;


    public int getCharacterDesign() {
     return int_characterDesign;
    }



    /**
     *
     *      OLD GAME CODE FOR PARSING INVENTORY & PLAYER TUPLE
     *      Cannot be removed yet until it has been purged
     *
     */

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

    public String getPlayertuple() {


        return player_tuple;
    }




    /**
     *  File writing code that is now obsolete
     *
     * @param data
     * @param context
     */
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


    /**
     * File reading code that is now obsolete
     *
     * @param context
     * @return
     */
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

    /**
     * Read player from file code that is now obsolete as using a server, dbms system
     */
    private void readPlayerFile() {


        //read file

        //file format: playerid_att (other files, playerid_log, playerid_server)
        //player_id(12),lemon8,sugar8,water8,money64
        //000000000000+00000000+00000000+00000000+0x64






    }










}

