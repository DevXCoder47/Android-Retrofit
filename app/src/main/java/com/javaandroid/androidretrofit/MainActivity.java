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

public class MainActivity extends AppCompatActivity {

    ArrayList<Film> films = new ArrayList<Film>(List.of(new Film(1, "F1"),
            new Film(2, "F2"),
            new Film(3, "F3"),
            new Film(4, "F4"),
            new Film(5, "F5")));

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
        ListView filmList = findViewById(R.id.filmList);
        FilmAdapter filmAdapter = new FilmAdapter(this, R.layout.film_list_item, films);
        filmList.setAdapter(filmAdapter);
    }
}