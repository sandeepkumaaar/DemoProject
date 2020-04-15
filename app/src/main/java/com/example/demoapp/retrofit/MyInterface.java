package com.example.demoapp.retrofit;

import com.example.demoapp.modal.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {

    @GET("hamburger_menu")
    Call<DataModel> getAllData();

}
