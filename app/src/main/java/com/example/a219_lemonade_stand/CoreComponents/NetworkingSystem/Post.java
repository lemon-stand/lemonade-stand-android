package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;


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




    public String getAccessToken() { return accessToken; };
    public String getRefreshToken() { return refreshToken; };





    public int getId() {
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
