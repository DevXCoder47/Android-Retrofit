package com.javaandroid.androidretrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("/movies")
    Call<List<Film>> getFilms();
}
