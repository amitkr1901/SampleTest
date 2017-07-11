package com.example.akumar.sample;

/**
 * Created by akumar on 7/11/2017.
 */


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amit on 11/01/17.
 */

public class RestApiClient {
    public static final String BASE_URL = "http://scube.net.in/seqr_scan/services/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
