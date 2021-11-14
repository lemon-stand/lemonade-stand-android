package com.example.a219_lemonade_stand;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Player {

    private int playerid;

    private int lemons;
    private int sugar ;
    private int water ;
    private int money ;



    public Player(int _playerid) {

        playerid = _playerid;


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
