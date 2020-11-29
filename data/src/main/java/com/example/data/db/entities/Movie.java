package com.example.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "movies")
public class Movie {
    @ColumnInfo(name = "id")
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "title")
    public String title;
    @ColumnInfo(name = "release_date")
    public String releaseDate;
    @ColumnInfo(name = "poster_path")
    public String image;
    @ColumnInfo(name = "original_language")
    public String language;
}
