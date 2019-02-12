package com.lonchi.andrej.retrofitex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lonchi.andrej.retrofitex.R;
import com.lonchi.andrej.retrofitex.model.Movie;

import java.util.Objects;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        //  Get UI elements
        ImageView movieImage = (ImageView) findViewById(R.id.movie_image);
        TextView movieTitle = (TextView) findViewById(R.id.movie_title);
        TextView movieGenres = (TextView) findViewById(R.id.movie_genre);
        TextView movieReleaseDate = (TextView) findViewById(R.id.movie_release_date);
        TextView movieDescription = (TextView) findViewById(R.id.movie_desc);

        //  Get passed data
        Intent mIntent = getIntent();
        Movie mMovie = (Movie) mIntent.getSerializableExtra("Object");

        //  Set UI elements
        movieTitle.setText(mMovie.getTitle());
        movieGenres.setText(mMovie.getMovieGenres());
        movieReleaseDate.setText(mMovie.getReleaseDate());
        movieDescription.setText(mMovie.getOverview());
        Glide.with(this).load(mMovie.getPosterUrl(3)).into(movieImage);
    }
}
