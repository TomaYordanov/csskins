package com.example.homoseksualizum;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestClient {
@GET("{lang}/skins.json")
    Call<SkinModel[]> getSkins(@Path("lang")String language);


}
