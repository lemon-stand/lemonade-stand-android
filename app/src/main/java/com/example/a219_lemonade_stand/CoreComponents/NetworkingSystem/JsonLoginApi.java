package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface JsonLoginApi {

    @POST
    Call<List<Post>>loginauth();
}
