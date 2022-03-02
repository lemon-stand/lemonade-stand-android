package com.example.a219_lemonade_stand.CoreComponents.NetworkingSystem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    //  Intructional guide and reference comment
    //
    // https://youtu.be/4JGvDUlfk7Y?t=582
    //
    // https://www.youtube.com/watch?v=GP5OyYDu_mU&list=PLrnPJCHvNZuCbuD3xpfKzQWOj3AXybSaM&index=3&ab_channel=CodinginFlow


    @GET("api/players")
    Call<List<Post>> getPosts();

    @GET("api/players/{id}")
    Call<Post> getPlayer(@Path("id") long postID);

    @GET("api/players/{username}")
    Call<Post> getPlayerByName(@Path("username") String player_name);

    @POST("api/players/{id}")
    Call<List<PlayerPost>> savePlayer_Store( @Path("id") long playerID, long lemons, long sugar, long water, long balance);

    @POST("api/players/{id}")
    Call<List<PlayerPost>> savePlayer_SPGame( @Path("id") long playerID, long lemons, long sugar, long water, long balance);




    @GET("api/players")
    Call<Post> loginPost(@Body Post post);





}
