package com.javaandroid.androidretrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("all-films")
    Call<List<Film>> getFilms();
}
