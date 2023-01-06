package com.example.networks2.Modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networks2.Interface.OnClick;
import com.example.networks2.databinding.ItemModelProviderBinding;

import java.util.ArrayList;

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.rvViewHolder>{

    Context context;
    ArrayList<ProfessionModel> arrayList;
    OnClick onClick;

    public AdapterRecycle(Context context, ArrayList<ProfessionModel> arrayList,OnClick onClick) {
        this.context = context;
        this.arrayList = arrayList;
        this.onClick=onClick;
    }


    @NonNull
    @Override
    public rvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new rvViewHolder(ItemModelProviderBinding.inflate(LayoutInflater.from(context),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull rvViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class rvViewHolder extends RecyclerView.ViewHolder {

        ItemModelProviderBinding b;
        public rvViewHolder(@NonNull ItemModelProviderBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
}


