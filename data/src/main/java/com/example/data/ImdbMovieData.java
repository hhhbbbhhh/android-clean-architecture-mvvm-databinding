package com.example.data;

import android.content.Context;

import com.example.data.db.MovieDatabase;

import com.example.data.db.entities.Movie;
import com.example.data.models.MovieResponse;
import com.example.data.rest.Connection;
import com.example.data.rest.MoviesApi;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ImdbMovieData {
    private static String API_KEY = "4cef18ce1205491d2cc20e9666804053";
    private static String BASE_URL = "https://api.themoviedb.org/";
    private static ImdbMovieData imdbMovieData = null;
    private MovieDatabase database;

    private ImdbMovieData(final Context context) {
        database = MovieDatabase.getInstance(context);
    }

    public static ImdbMovieData getInstance(final Context context) {
        if(null == imdbMovieData) {
            imdbMovieData = new ImdbMovieData(context);
        }
        return imdbMovieData;
    }

    // Test
    public void getPlayNowList(final int page) throws IOException {
        if (null == database) {
            return;
        }
        //loadData();
        Flowable<List<Movie>> flowable = database.moviesDao().getPlayNowList();
        flowable.subscribe(new Consumer<List<Movie>>() {
            @Override
            public void accept(List<Movie> movies) throws Exception {
                for(Movie move: movies) {
                    System.out.println("# Movie " + move.title);
                }

            }
        });
    }
    public void loadData() {
        MoviesApi api = Connection.getData(BASE_URL).create(MoviesApi.class);
        api.getNowPlayingList(API_KEY, 1).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                System.out.println("#OnResponse " + response.body().getMovieList().size());
                List<com.example.data.models.Movie> moviesList = response.body().getMovieList();
                for (com.example.data.models.Movie movie: moviesList) {
                    Movie dbMovie = new Movie();
                    dbMovie.id = movie.getId();
                    dbMovie.title = movie.getTitle();
                    dbMovie.image = movie.getImage();
                    dbMovie.language = movie.getLanguage();
                    dbMovie.releaseDate = movie.getReleaseDate();
                    database.moviesDao().insertMovie(dbMovie)
                    .subscribeOn(Schedulers.io())
                            .subscribe();

                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                System.out.println("# onFailure " + t.getMessage());
            }
        });
    }
}
