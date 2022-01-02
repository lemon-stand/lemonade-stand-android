package com.example.a219_lemonade_stand.GameEngineSystem;

import static java.lang.Math.abs;
import static java.lang.Math.floor;
import static java.lang.Math.random;

import java.util.Random;

public class GameObject {

    public int inital_lemons = 1000;
    public int inital_sugar =  300;
    public int inital_water =  1000;
    public int inital_money =  6000;


    private static int lemons = 0;
    private static int sugar = 0;
    private static int water = 0;
    private static double Balance = 5000;


    private Recipe recipeObj = new Recipe();
    private Pricing pricingObj = new Pricing();

    private LStandBusinessAdminObj BusinessAdminObj= new LStandBusinessAdminObj();

    //temp can be between -2 and 30
    private int temperature;

    //0 none, 1 rain, 2 snow, 3 windy
    private int weatherstate;

    //1/5 of rain
    private boolean chanceofRain;

    //1/2 of snow
    private boolean chanceofSnow;

    public int getTemperature(){
        return temperature;
    }

    public int getWeatherState() {
        return weatherstate;
    }


    private static int currentSellLocation = 0;

    public int getSellLocation( ) {
        return currentSellLocation;
    }

    public void changeSellLocation(int _loc) {
        currentSellLocation = _loc;
    }





    /**
     * business admin object
     *
     */
    public class LStandBusinessAdminObj {

        private long revenue = 0;
        private long overhead = 0;
        private long profit = 0;        // maybe range or expected range


        //profit = revenue - overhead;






    }

    //doesnt work
    public double getRevenue() {
        return BusinessAdminObj.revenue;
    }

    // same as
    public double getOverhead() {
        //return BusinessAdminObj.overhead;
        return getrecipecost();
    }

    //same as - could provide range
    public double getProfit() {
        //return BusinessAdminObj.profit;
        return getrecipeprofit();
    }

    public static int generatRandomPositiveNegitiveValue(int max , int min) {
        //Random rand = new Random();
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        return ii;
    }

    /**
     *
     * Main game object
     */
    public GameObject()
    {

        if(lemons == -1) {
            //lemons = inital_lemons;
        }


        temperature = generatRandomPositiveNegitiveValue(30, -2);

        //check for rain
        int rainchance = new Random().nextInt((7 - 1) + 1 ) + 1;

        //check for rain

        int snowchance = new Random().nextInt((2 - 1) + 1 ) + 1;

        if(rainchance == 1) {
            chanceofRain = true;
        }
        else {
            chanceofRain = false;
        }

        if(snowchance == 2) {
            chanceofSnow = true;
        } else {
            chanceofSnow = false;
        }

        weatherstate = 0;

        if(temperature <= 14) {
            weatherstate = 3;
        }

        if(chanceofRain == true) {
            weatherstate = 1;

            if (chanceofSnow == true) {
                if(temperature <= 2) {
                    weatherstate = 2;
                }

            }

        }






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



    public void buyLemons()
    {
        lemons += 15;
        Balance -= 5;
    }

    public void buySugar()
    {
        sugar += 20;
        Balance -= 100;
    }

    public void buyWater()
    {
        water += 100;
        Balance -= 5;
    }

    public void useLemons()
    {
        recipeObj.useRecipe();
        pricingObj.usePricing();

    }

    public double getPPC(){

        return pricingObj.getPricingpercup();
    }

    public double getrecipeprofit(){

        double profit = pricingObj.getPricingpercup() -+ (-1 * (use_lemons + use_sugar + use_water));

        return profit;
    }


    public double getrecipecost() {
        double totalcost = (use_lemons + use_sugar + use_water);
        return totalcost;
    }

    public double getBalance(){
        return Balance;
    }

    private static int use_lemons = 5;
    private  static int use_sugar = 2;
    private static int use_water = 10;

    public void changeUseLemons(int val) {

        use_lemons = use_lemons + val;
    }
    public void changeUseSugar(int val) {

        use_sugar = use_sugar +  val;
    }
    public void changeUseWater(int val) {
        use_water = use_water + val;
    }

    public int getUseLemons(){ return use_lemons; }
    public int getUseSugar() { return use_sugar;
    }
    public int getUseWater() { return use_water; }




    /**
     * Recipe class object
     */
    public class Recipe {



        public Recipe() {


        }

        public void useRecipe() {

            lemons = (lemons - use_lemons);
            sugar = (sugar - use_sugar);
            water = (water - use_water);

        }


    }


    /**
     * Pricing game object
     */
    public class Pricing {


        private double pricingpercup = 20;
        private double increment = 0.2;

        public Pricing() {


        }

        public void usePricing() {

            Balance = (Balance + pricingpercup);
        }

        public void decreasePricingIncrement() {

            pricingpercup = (pricingpercup - increment);

            //check for negative or less than a minimum

        }

        public void increasePricingIncrement() {

            pricingpercup = (pricingpercup + increment);

            //maybe issue standard warning when asking for expensive cup

        }

        public double getPricingpercup() {

            return pricingpercup;
        }


    }

    //use and change pricing using game object main operation

    public void dodecrement(){
       pricingObj.decreasePricingIncrement();
    }
    public void doincrement() {
        pricingObj.increasePricingIncrement();
    }







}
