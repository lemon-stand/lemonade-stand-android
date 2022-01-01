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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Player {

    private int playerid;

    private int lemons;
    private int sugar ;
    private int water ;
    private int money ;

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

    public void setPlayertuple(String tuple) {
        player_tuple = tuple;
    }

    public String getPlayertuple() {


        return player_tuple;
    }

    public Player() {


        //0 = bob , 1 james, 2 edna
        int_characterDesign =3;

        //k = knife, c= cooler, z = empty, a = adboard
        //player_inventory = "KCZZZZZZZ";
        //selected_inventory = player_inventory.substring(0, 3);

        //http://192.168.0.12:8080/api/v1/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()) {
                    System.out.println("code:" + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for(Post post : posts ) {

                    int bo = 0;

                    String content = "";
                    content+="ID: " + post.getId() + "\n";
                    content+="Name: " + post.getName() + "\n";
                    content+="dob: " + post.getDob() + "\n";
                    content+="email: " + post.getEmail() + "\n";

                    player_tuple =content;
                    if(bo == 0){
                        setPlayertuple(content);

                        System.out.println(content);
                    }
                    bo++;

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                System.out.println("error" + t.getMessage());
            }
        });











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

    public int returnLemonStock() {

        return lemons;
    }








}







//////////
///
///
