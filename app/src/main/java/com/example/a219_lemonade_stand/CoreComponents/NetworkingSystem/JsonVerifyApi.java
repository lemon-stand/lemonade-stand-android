package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JsonVerifyApi {

    @POST("api/token/refresh")
    Call<verifyPost> verifyPost(@Body verifyPost vpost);


}
