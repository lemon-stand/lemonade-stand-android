package com.example.a219_lemonade_stand;

import static java.lang.Math.abs;

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


    /**
     *
     * Main game object
     */
    public GameObject()
    {

        if(lemons == -1) {
            //lemons = inital_lemons;
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
        double totalcost = -1*(use_lemons + use_sugar + use_water);
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

            lemons = (lemons + use_lemons);
            sugar = (sugar + use_sugar);
            water = (water + use_water);

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
