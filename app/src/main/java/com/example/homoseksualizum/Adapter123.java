package com.example.homoseksualizum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter123 extends RecyclerView.Adapter<SkinViewHolder> {
SkinModel[] MAJKATIEMOMCHE;
public Adapter123(SkinModel[] MAJKATIEMOMCHE){
    this.MAJKATIEMOMCHE = MAJKATIEMOMCHE;
}
    @NonNull
    @Override
    public SkinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skin_layot, parent, false);
        return new SkinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkinViewHolder holder, int position) {
    SkinModel model = MAJKATIEMOMCHE[position];
    holder.setTextView(model.getName());
    holder.setImageView(model.getImage());
    }

    @Override
    public int getItemCount() {
        return MAJKATIEMOMCHE.length;
    }
}
