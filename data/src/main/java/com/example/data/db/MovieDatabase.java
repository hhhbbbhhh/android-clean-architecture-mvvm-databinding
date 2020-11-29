package com.example.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.data.db.dao.MoviesDao;
import com.example.data.db.entities.Movie;

@Database(entities = Movie.class, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

    private static volatile MovieDatabase movieDatabase = null;

    public abstract MoviesDao moviesDao();

    public static MovieDatabase getInstance(Context context) {
        synchronized (MovieDatabase.class) {
            if (null == movieDatabase) {
                movieDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDatabase.class, "Movies.db").build();
            }
        }
        return movieDatabase;
    }

}
