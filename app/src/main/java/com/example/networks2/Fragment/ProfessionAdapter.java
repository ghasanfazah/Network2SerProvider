package com.example.networks2.Fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networks2.Modal.ProfessionModel;
import com.example.networks2.R;
import com.example.networks2.databinding.ModelIconsBinding;

import java.util.ArrayList;

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ProfessionViewHolder> {

    Context context;
    ArrayList<ProfessionModel> arrayList;

    public ProfessionAdapter(Context context, ArrayList<ProfessionModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ProfessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfessionViewHolder(ModelIconsBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionViewHolder holder, int position) {
        ProfessionModel model = arrayList.get(position);
        holder.b.tvModel.setText(model.getTitle());
        if (position == 0) {
            holder.b.imageModel.setImageResource(R.drawable.service2_mdpi);
        } else if (position == 1) {
            holder.b.imageModel.setImageResource(R.drawable.service_mdpi);
        }
//        holder.itemView.setOnClickListener(view -> {
//            context.startActivity(new Intent(context, .class)
//                    .putExtra("id", model.getId() + 1)
//                    .putExtra("name", model.getTitle()));
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ProfessionViewHolder extends RecyclerView.ViewHolder {

        ModelIconsBinding b;

        public ProfessionViewHolder(ModelIconsBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
}
