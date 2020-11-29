package com.example.data;

import com.example.data.models.MovieResponse;
import com.example.data.rest.Connection;
import com.example.data.rest.MoviesApi;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;

public class ImdbMovieData {
    private static String API_KEY = "4cef18ce1205491d2cc20e9666804053";
    private static String BASE_URL = "https://api.themoviedb.org/";
    private static ImdbMovieData imdbMovieData = null;

    private ImdbMovieData() {
    }

    public static ImdbMovieData getInstance() {
        if(null == imdbMovieData) {
            imdbMovieData = new ImdbMovieData();
        }
        return imdbMovieData;
    }

    // Test
    public void getPlayNowList(final int page) throws IOException {
        MoviesApi api = Connection.getData(BASE_URL).create(MoviesApi.class);
        Response<MovieResponse> playNowList = api.getNowPlayingList(API_KEY, page).execute();
        System.out.println(playNowList.body().toString() + "");
    }
}
