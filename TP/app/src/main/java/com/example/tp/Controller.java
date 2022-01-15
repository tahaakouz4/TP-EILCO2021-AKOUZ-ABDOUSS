package com.example.tp;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;


public class Controller extends Application {
    private List<Movie> movies;

    @Override
    public void onCreate() {
        super.onCreate();
        this.movies = new ArrayList<Movie>();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public boolean addMovie(Movie movie) {
        return this.movies.add(movie);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean removeMovie(Movie movie){
        int m = movie.getId();

        return this.movies.removeIf(n ->n.id==m);

    }

    public boolean containsMovie(Movie movie){
        for(int i=0; i<movies.size(); i++){
            if(movie.equals(movies.get(i)))
                return true;
        }
        return false;
    }
}