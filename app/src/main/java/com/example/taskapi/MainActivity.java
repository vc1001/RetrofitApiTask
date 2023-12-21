package com.example.taskapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.taskapi.databinding.ActivityMainBinding;
import com.example.taskapi.model.Datum;
import com.example.taskapi.model.Example;
import com.example.taskapi.view.MyAdapter;
import com.example.taskapi.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    RecyclerView recyclerView;

    MyAdapter myAdapter;

    ArrayList<Datum> exampleArrayList;

    MyViewModel myViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel=new ViewModelProvider(this).get(MyViewModel.class);

        showdata();

    }

    private void showdata(){

        myViewModel.getLivedata().observe(this, new Observer<List<Datum>>() {
            @Override
            public void onChanged(List<Datum> data) {
                exampleArrayList=(ArrayList<Datum>) data;

                displaydatainRecyclerview();

            }
        });

    }

    private void displaydatainRecyclerview(){

        recyclerView = binding.recyclervciew;

        myAdapter = new MyAdapter(this,exampleArrayList);
        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.notifyDataSetChanged();
    }
}