package com.example.homoseksualizum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFavourites extends RecyclerView.Adapter<SkinViewHolder> {
List<SkinEntity> skins;
    @NonNull
    @Override
    public SkinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skin_layot, parent, false);
        return new SkinViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull SkinViewHolder holder, int position) {
    SkinEntity skin = skins.get(position);
    holder.setImageView(skin.image);
    holder.setTextView(skin.name);
    holder.button.setText("unfavourite");
    holder.button.setOnClickListener(v ->
    {
        skins.remove(position);
        SkinDAO skinDAO = MainActivity.appDatabase.skinDAO();
        skinDAO.deleteSkin(skin.getId());
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, skins.size());
    });
    }

    @Override
    public int getItemCount() {
        return skins.size();
    }
    public AdapterFavourites(List<SkinEntity> skins)
    {
         this.skins = skins;
    }
}
