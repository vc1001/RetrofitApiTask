package com.example.taskapi.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskapi.model.Datum;
import com.example.taskapi.model.Example;
import com.example.taskapi.services.ApiService;
import com.example.taskapi.services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    ApiService getapiservice;
    ArrayList<Datum> exampleArrayList;

    public LiveData<List<Datum>> getlivedata(){
        MutableLiveData<List<Datum>> data =new MutableLiveData<>();
        getapiservice=RetrofitInstance.apiService();
        Call<Example> response=getapiservice.getAllData();
        response.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response!=null){
                    Example ex = response.body();
                    if(ex!=null && ex.getData()!=null){
                        exampleArrayList= (ArrayList<Datum>) ex.getData();
                        data.setValue(exampleArrayList);

                    }
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
        return data;
    }




}
