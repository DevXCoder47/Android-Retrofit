package com.javaandroid.androidretrofit;

public class Film {
    private int Id;
    private String Title;

    public Film(){}
    public Film(int id, String title) {
        Id = id;
        Title = title;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
