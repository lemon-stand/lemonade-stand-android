package com.example.a219_lemonade_stand;

public class GameObject {

    public int inital_lemons = 1000;
    public int inital_sugar =  300;
    public int inital_water =  1000;
    public int inital_money =  6000;


    public static int lemons = 0;
    public static int sugar = 0;
    public static int water = 0;
    public static double money = 5000;

    private Recipe recipeObj = new Recipe();
    private Pricing pricingObj = new Pricing();

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

    public double getMoney(){
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
        recipeObj.useRecipe();
        pricingObj.usePricing();

    }

    public double getPPC(){

        return pricingObj.getPricingpercup();
    }


    public class Recipe {

        private int use_lemons = -5;
        private  int use_sugar = -2;
        private int use_water = -10;

        public Recipe() {


        }

        public void useRecipe() {

            lemons = (lemons + use_lemons);
            sugar = (sugar + use_sugar);
            water = (water + use_water);

        }


    }

    public class Pricing {


        private double pricingpercup = 20;
        private double increment = 0.2;

        public Pricing() {


        }

        public void usePricing() {

            money = (money + pricingpercup);
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





}
