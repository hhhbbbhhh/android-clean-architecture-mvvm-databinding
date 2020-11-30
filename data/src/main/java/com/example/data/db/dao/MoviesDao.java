package com.example.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.example.data.db.entities.Movie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertMovie(Movie movie);

    @Query("select * from movies")
    Observable<List<Movie>> getPlayNowList();

    @Query("Delete from movies")
    void clearMovies();

}
