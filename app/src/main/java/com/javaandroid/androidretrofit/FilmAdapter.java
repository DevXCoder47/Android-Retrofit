package com.javaandroid.androidretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FilmAdapter extends ArrayAdapter<Film> {
    private LayoutInflater inflater;
    private int layout;
    private List<Film> films;

    public FilmAdapter(Context context, int resource, List<Film> films) {
        super(context, resource, films);
        this.films = films;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        TextView idView = view.findViewById(R.id.idView);
        TextView titleView = view.findViewById(R.id.titleView);

        Film film = films.get(position);

        idView.setText(String.valueOf(film.getId()));
        titleView.setText(film.getTitle());

        return view;
    }
}
