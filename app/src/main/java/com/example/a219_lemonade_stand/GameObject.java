package com.example.a219_lemonade_stand;

public class GameObject {

    public int inital_lemons = 1000;
    public int inital_sugar =  300;
    public int inital_water =  1000;
    public int inital_money =  6000;


    public static int lemons = 0;
    public static int sugar = 0;
    public static int water = 0;
    public static int money = 5000;

    public GameObject()
    {




    }



    // 1 = prep stage, 2 = sell stage
    int gameStatus = 1;


    //bool notification window

    //bool profit window

    public int getSugar(){

        return sugar;
    }

    public int getWater(){

        return water;
    }

    public int getLemons() {

        return lemons;
    }

    public int getMoney(){
        return money;
    }


    public void buyLemons()
    {
        lemons += 15;
        money -= 5;
    }

    public void buySugar()
    {
        sugar += 20;
        money -= 100;
    }

    public void buyWater()
    {
        water += 100;
        money -= 5;
    }

    public void useLemons()
    {
        lemons -= 5;
        sugar -= 2;
        water -= 5;
        money +=20;
    }





}
