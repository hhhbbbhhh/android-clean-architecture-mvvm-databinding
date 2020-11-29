package com.example.data.rest;

import android.content.Context;

import com.example.data.rest.callback.MovieDataRequestCallback;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Connection {
    // Method to get Cronet connection for given URL
    public static UrlRequest getData(Context context, final String url, UrlRequest.Callback callback) {
        CronetEngine.Builder engineBuilder = new CronetEngine.Builder(context);
        CronetEngine engine = engineBuilder.build();
        Executor executor = Executors.newSingleThreadExecutor();
        UrlRequest.Builder requestBuilder = engine.newUrlRequestBuilder(
                url, callback, executor);
        return requestBuilder.build();
    }
}
