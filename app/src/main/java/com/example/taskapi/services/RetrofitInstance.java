package com.example.taskapi.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

   private static Retrofit retrofit= null;
   private static  String Base_Url="https://reqres.in/";

   public static ApiService apiService(){
      if (retrofit==null){
         retrofit=new Retrofit.Builder().
                 baseUrl(Base_Url).
                 addConverterFactory(GsonConverterFactory.create()).build();
      }
      return retrofit.create(ApiService.class);

   }


}
