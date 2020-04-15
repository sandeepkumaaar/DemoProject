package com.example.demoapp.retrofit;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyAPI {

    private static Retrofit retrofit = null;

    private static final String URL = "https://alphamtappfeed.intoday.in/appapi/nt/";

    private static OkHttpClient buildClient(){
        return new OkHttpClient
                .Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static Retrofit getClient(Context context){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(buildClient())
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
