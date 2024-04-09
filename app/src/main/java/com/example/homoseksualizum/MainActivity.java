package com.example.homoseksualizum;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    loadSWCharacters(requestClient);

    }
    private void loadSWCharacters(RequestClient SkinModel) {
        Call<SkinModel[]> call = SkinModel.getSkins("en");
        call.enqueue(new Callback<SkinModel[]>() {
            @Override
            public void onResponse(Call<SkinModel[]> call, Response<SkinModel[]> response) {
                if (response.isSuccessful()) {
                    SkinModel[] SkinModel = response.body();
                   // editor.putInt("currentPage", page);
                  //  editor.apply();
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
        Adapter123 adapter123 = new Adapter123(models);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter123);
    }
}