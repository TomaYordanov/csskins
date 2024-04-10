package com.example.homoseksualizum;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<SkinViewHolder> {
SkinModel[] MAJKATIEMOMCHE;
AppDatabase database;
public AdapterMain(SkinModel[] MAJKATIEMOMCHE, AppDatabase database){
    this.MAJKATIEMOMCHE = MAJKATIEMOMCHE;
    this.database = database;
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
    SkinDAO skinDAO = database.skinDAO();
    SkinModel model = MAJKATIEMOMCHE[position];
        List<SkinEntity> skins = skinDAO.findSkinById(model.getId());
        boolean isFavourited = skins.size() > 0;
        holder.button.setText(isFavourited ? "unfavourite" : "favourite");
        holder.setTextView(model.getName());
    holder.setImageView(model.getImage());
    holder.button.setOnClickListener(v -> {
        insertSkin(model, skinDAO, isFavourited );
        notifyItemChanged(holder.getAdapterPosition());


        });
    }
    public void insertSkin(SkinModel model, SkinDAO skinDAO, boolean isFavourited)
    {
        SkinEntity skin = new SkinEntity(model.getName(), model.getImage(), model.getId());
        if (!isFavourited){
            skinDAO.insertSkin(skin);
        }
        else {
            skinDAO.deleteSkin(skin.getId());
        }
    }
    @Override
    public int getItemCount() {
        return MAJKATIEMOMCHE.length;
    }
}
