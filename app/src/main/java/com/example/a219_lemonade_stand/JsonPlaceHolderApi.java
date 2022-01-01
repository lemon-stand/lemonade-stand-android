package com.example.a219_lemonade_stand;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/v1/player")
    Call<List<Post>> getPosts();

    //comment
    // https://youtu.be/4JGvDUlfk7Y?t=582
}
