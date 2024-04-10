package com.example.homoseksualizum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Favourites extends AppCompatActivity {
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites);
    recyclerView = findViewById(R.id.patka2);
    Button goBack = findViewById(R.id.return123);
    Intent back = new Intent(this, MainActivity.class);
        goBack.setOnClickListener(v -> {startActivity(back);});
        SkinDAO skinDAO = MainActivity.appDatabase.skinDAO();
        List<SkinEntity> skins = skinDAO.findAllSkins();
        AdapterFavourites adapter = new AdapterFavourites(skins);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
}


}
