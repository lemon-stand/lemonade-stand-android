package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;
    private String name ="";
    private String dob = "";

    @SerializedName("email")
    private String email = "";


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }
}
