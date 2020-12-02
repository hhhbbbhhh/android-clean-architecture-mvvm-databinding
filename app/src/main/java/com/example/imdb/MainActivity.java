package com.example.imdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.data.ImdbMovieData;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ImdbMovieData.getInstance(getApplicationContext()).getPlayNowList(1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
