package nl.evertwoud.recipeapp;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    String BASE_URL = "https://www.food2fork.com/api/";
    String API_KEY = "6405c4f634a4b30536e6706225f8da43";
    String SORT = "&?sort=t&count=30";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("search?key=" + API_KEY + SORT)
    Call<APIResponse> getRecipes();

}
