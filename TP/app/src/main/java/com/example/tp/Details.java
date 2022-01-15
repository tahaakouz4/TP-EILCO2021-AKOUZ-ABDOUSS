package com.example.tp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    final String imgBaseUrl = "https://image.tmdb.org/t/p/original";

    Movie movie;
    ArrayList<String> movieGenres;
    ImageView imageMovie;
    TextView description;
    TextView date;
    TextView genres;
    Controller app;
    Button addfavorite;
    Button removefavorite;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movie = (Movie) getIntent().getSerializableExtra("movie");
        movieGenres = (ArrayList<String>) getIntent().getSerializableExtra("genres");
        imageMovie = (ImageView) findViewById(R.id.imageMovie);
        description = (TextView) findViewById(R.id.descriptionMovie);
        date = (TextView) findViewById(R.id.date);
        genres = (TextView) findViewById(R.id.genres);
        addfavorite = (Button) findViewById(R.id.addfavorite);
        removefavorite = (Button) findViewById(R.id.removefavorite);
        app = (Controller) getApplicationContext();

        setTitle(movie.getTitle());
        addfavorite.setVisibility(app.containsMovie(movie) ? View.INVISIBLE : View.VISIBLE);
        removefavorite.setVisibility(app.containsMovie(movie) ? View.VISIBLE : View.INVISIBLE);
        Glide.with(this).load(imgBaseUrl+movie.getBackdrop_path()).into(imageMovie);
        date.setText(movie.getRelease_date());
        description.setText(movie.getOverview());
        System.out.println("context movies : " + app.getMovies());
        if(movieGenres != null && movieGenres.size() > 0)
            genres.setText(" - " + String.join("\n - ", movieGenres));

        addfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!app.containsMovie(movie))
                    if(app.addMovie(movie)){
                        addfavorite.setVisibility(View.INVISIBLE);
                        Toast.makeText(Details.this, "Movie added to favorites!", Toast.LENGTH_SHORT).show();
                        removefavorite.setVisibility(View.VISIBLE);
                    }
            }
        });
        removefavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(app.containsMovie(movie))
                    if(app.addMovie(movie)){
                        removefavorite.setVisibility(View.INVISIBLE);
                        Toast.makeText(Details.this, "Movie removed from favorites, Please Refresh Your favorites Page !", Toast.LENGTH_SHORT).show();
                        app.removeMovie(movie);
                        addfavorite.setVisibility(View.VISIBLE);


                    }
            }
        });
    }
}