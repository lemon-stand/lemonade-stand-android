package com.example.a219_lemonade_stand;

public class GameObject {

    public int lemons;
    public int sugar;
    public int water;
    public int money;

    public GameObject()
    {
        lemons = 999;
        sugar = 100;
        water = 1000;
        money = 200;
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

    public void useLemons()
    {
        lemons -= 5;
        sugar -= 2;
        water -= 5;
        money +=20;
    }





}
