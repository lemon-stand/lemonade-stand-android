package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import com.google.gson.annotations.SerializedName;

public class LoginPost {

    public String getAccess_token() {
        return access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public String getText() {
        return text;
    }

    private String access_token;
    private String refresh_token;

    @SerializedName("body")
    private String text;

}
