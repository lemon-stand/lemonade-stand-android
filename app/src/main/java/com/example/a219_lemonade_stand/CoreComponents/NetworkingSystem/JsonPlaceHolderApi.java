package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/v1/player")
    Call<List<Post>> getPosts();


    //comment
    // https://youtu.be/4JGvDUlfk7Y?t=582

    //https://www.youtube.com/watch?v=GP5OyYDu_mU&list=PLrnPJCHvNZuCbuD3xpfKzQWOj3AXybSaM&index=3&ab_channel=CodinginFlow


    @POST("api/login")
    Call<Post> createPost(@Body Post post);
}
