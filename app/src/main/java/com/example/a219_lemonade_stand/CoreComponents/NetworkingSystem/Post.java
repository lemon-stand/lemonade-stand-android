package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import com.google.gson.annotations.SerializedName;


public class Post {

    @SerializedName("id")
    private Long id;


    @SerializedName("username")
    private String username ="";



    @SerializedName("password")
    private String password = "";

    @SerializedName("email")
    private String email = "";

    @SerializedName("body")
    private String text = "";

    private String dob = "";


    public Post(String username, String password) {

        this.username = username;
        this.username = password;

    }


    private String accessToken = "";
    private String refreshToken = "";

    @SerializedName("balance")
    private Long balance;

    @SerializedName("lemons")
    private Long lemons;

    @SerializedName("shiny_lemons")
    private Long shiny_lemons;

    @SerializedName("sugar")
    private Long sugar;

    @SerializedName("honey")
    private Long honey;

    @SerializedName("water")
    private Long water;

    public String getText() {
        return text;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getLemons() {
        return lemons;
    }

    public Long getShiny_lemons() {
        return shiny_lemons;
    }

    public Long getSugar() {
        return sugar;
    }

    public Long getHoney() {
        return honey;
    }

    public Long getWater() {
        return water;
    }






    public String getAccessToken() { return accessToken; };
    public String getRefreshToken() { return refreshToken; };





    public Long getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() { return text; }












}
