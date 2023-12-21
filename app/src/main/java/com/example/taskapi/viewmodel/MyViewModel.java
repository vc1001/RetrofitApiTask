package com.example.taskapi.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskapi.model.Datum;
import com.example.taskapi.repository.Repository;

import java.util.List;

public class MyViewModel extends ViewModel {

    Repository repository;
    LiveData<List<Datum>> livedata;


    public MyViewModel() {
        this.repository=new Repository();
        livedata=repository.getlivedata();
    }
    public LiveData<List<Datum>> getLivedata(){
        return repository.getlivedata();
    }
}
