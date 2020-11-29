package com.example.data;

import android.content.Context;

import com.example.data.rest.Connection;
import com.example.data.rest.callback.MovieDataRequestCallback;

public class ImdbMovieData {
    private static String API_KEY = "4cef18ce1205491d2cc20e9666804053";
    private static String PLAY_NOW_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=4cef18ce1205491d2cc20e9666804053&language=en-US&page=1";
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
    public void getPlayNowList(Context context) {
        MovieDataRequestCallback callback = new MovieDataRequestCallback();
        Connection.getData(context, PLAY_NOW_URL, callback).start();
    }
}
