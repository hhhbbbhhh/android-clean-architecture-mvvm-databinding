package com.example.data.rest;

import com.example.data.models.Movie;
import com.example.data.models.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("/3/movie/now_playing")
    Call<MovieResponse> getNowPlayingList(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/popular")
    Call<MovieResponse> getPopularList(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/3/movie/top_rated")
    Call<MovieResponse> getTopRatedList(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("/movie/upcoming")
    Call<MovieResponse> getUpcomingList(@Query("api_key") String apiKey, @Query("page") int page);
}
