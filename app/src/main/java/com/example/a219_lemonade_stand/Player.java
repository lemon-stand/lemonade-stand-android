package com.example.a219_lemonade_stand;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class Player {

    private int playerid;

    private int lemons;
    private int sugar ;
    private int water ;
    private int money ;


    public static String s_PlayerString = "NULL";
    public String getS_PString(){ return s_PlayerString; };

    public Player() {




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

    public int returnLemonStock() {

        return lemons;
    }








}
