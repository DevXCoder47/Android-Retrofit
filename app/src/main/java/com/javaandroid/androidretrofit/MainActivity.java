package com.javaandroid.androidretrofit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<List<Film>> call = apiService.getFilms();
        call.enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()) {
                    List<Film> films = response.body();
                    // Обробляємо список постів
                    ListView filmList = findViewById(R.id.filmList);
                    FilmAdapter filmAdapter = new FilmAdapter(MainActivity.this, R.layout.film_list_item, films);
                    filmList.setAdapter(filmAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
//npx json-server db.json