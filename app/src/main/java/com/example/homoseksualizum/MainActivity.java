package com.example.homoseksualizum;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String language = "en";
    public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database" ).allowMainThreadQueries().build();
        recyclerView = findViewById(R.id.patka);
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://bymykel.github.io/CSGO-API/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RequestClient requestClient = retrofit.create(RequestClient.class);
        SharedPreferences sharedPreferences = getSharedPreferences("golqmchep", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        language = sharedPreferences.getString("lang", "en");
    loadSWCharacters(requestClient , editor);
    Button englishButton = findViewById(R.id.englishButton);
    Button bulgarianButton = findViewById(R.id.bulgarskiButon);
    englishButton.setOnClickListener(v -> {
        language="en";
        loadSWCharacters(requestClient, editor);
    });
        bulgarianButton.setOnClickListener(v -> {
            language="bg";
            loadSWCharacters(requestClient, editor);
        });
    }
    private void loadSWCharacters(RequestClient SkinModel, SharedPreferences.Editor editor) {
        Call<SkinModel[]> call = SkinModel.getSkins(language);
        call.enqueue(new Callback<SkinModel[]>() {
            @Override
            public void onResponse(Call<SkinModel[]> call, Response<SkinModel[]> response) {
                if (response.isSuccessful()) {
                    SkinModel[] SkinModel = response.body();
                    editor.putString("lang", language);
                    editor.apply();
                    if (SkinModel != null) {
                        SetAdapter(SkinModel);
                        for (SkinModel model: SkinModel)
                              {
                            Log.d(TAG, "Response: " + model.getName());
                        }

                    } else {
                        Log.e(TAG, "Response is null");
                    }
                } else {
                    Log.e(TAG, "Failed to get cat facts: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<SkinModel[]> call, Throwable t) {
                Log.e(TAG, "Error getting sw response: " + t.getMessage());
            }
        });
    }
    private void SetAdapter(SkinModel[] models)
    {
        Adapter123 adapter123 = new Adapter123(models, appDatabase);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter123);
    }
}