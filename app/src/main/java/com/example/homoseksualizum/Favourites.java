package com.example.homoseksualizum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Favourites extends AppCompatActivity {
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites);
    recyclerView = findViewById(R.id.patka2);
    Button goBack = findViewById(R.id.return123);
    Intent back = new Intent(this, MainActivity.class);
        goBack.setOnClickListener(v -> {startActivity(back);});
}

}
