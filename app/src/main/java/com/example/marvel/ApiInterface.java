package com.example.marvel;

import com.example.marvel.comicmodels.ComicFile;
import com.example.marvel.model.CharacterFile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("characters")
    Call<CharacterFile> loadCharacters(@Query("ts") int ts, @Query("apikey") String apikey, @Query("hash") String Hash);

    @GET("comics")
    Call<ComicFile> loadComics(@Query("ts") int ts, @Query("apikey") String apikey, @Query("hash") String Hash);
}


//Test