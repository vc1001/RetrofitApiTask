package com.example.taskapi.services;

import com.example.taskapi.model.Example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/unknown")
    Call<Example> getAllData();
}
