package com.example.homoseksualizum;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class SkinViewHolder extends RecyclerView.ViewHolder {

    public SkinViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.skinname);
        imageView = itemView.findViewById(R.id.tovaesnimkata);
    }
    public TextView textView;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(String text) {
        this.textView.setText(text);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(String url) {
        Picasso.get().load(url).into(imageView);
    }

    public ImageView imageView;
}
