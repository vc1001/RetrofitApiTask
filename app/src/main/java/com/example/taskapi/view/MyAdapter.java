package com.example.taskapi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapi.R;
import com.example.taskapi.databinding.ItemLayoutBinding;
import com.example.taskapi.model.Datum;
import com.example.taskapi.model.Example;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ItemLayoutBinding binding;

    ArrayList<Datum> datumArrayList;



    public MyAdapter(Context context, ArrayList<Datum> datumArrayList) {
        this.context = context;
        this.datumArrayList = datumArrayList;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout,parent,false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Datum datum =datumArrayList.get(position);
        holder.binding.setUser(datum);

    }

    @Override
    public int getItemCount() {
        return datumArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ItemLayoutBinding binding;

        public MyViewHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                }
            });
        }
    }
}
