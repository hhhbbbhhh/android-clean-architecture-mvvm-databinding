package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.data.ImdbMovieData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImdbMovieData.getInstance().getPlayNowList(getApplicationContext());
    }
}
