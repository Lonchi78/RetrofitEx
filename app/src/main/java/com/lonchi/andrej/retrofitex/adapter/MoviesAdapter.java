package com.lonchi.andrej.retrofitex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lonchi.andrej.retrofitex.R;
import com.lonchi.andrej.retrofitex.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private static String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w300/";
    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout moviesLayoutOut;
        LinearLayout moviesLayout;
        ImageView movieImage;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayoutOut = (RelativeLayout) v.findViewById(R.id.movies_layout_out);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        //  Chnage description to genres!
        //holder.movieDescription.setText(movies.get(position).getOverview());
        holder.movieDescription.setText(getMovieGenres(movies.get(position).getGenreIds()));
        holder.rating.setText(String.valueOf(movies.get(position).getVoteAverage()));
        Glide.with(context).load(POSTER_BASE_URL+movies.get(position).getPosterPath()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private String getMovieGenres(List<Integer> genreIds){
        String movieGenres = "";
        String addGenre = "";

        for(int i=0; i<genreIds.size(); i++){
            //  Decode genre
            switch(genreIds.get(i)){
                case 28:
                    addGenre = "Action";
                    break;
                case 12:
                    addGenre = "Adventure";
                    break;
                case 16:
                    addGenre = "Animation";
                    break;
                case 35:
                    addGenre = "Comedy";
                    break;
                case 80:
                    addGenre = "Crime";
                    break;
                case 99:
                    addGenre = "Documentary";
                    break;
                case 18:
                    addGenre = "Drama";
                    break;
                case 10751:
                    addGenre = "Family";
                    break;
                case 14:
                    addGenre = "Fantasy";
                    break;
                case 36:
                    addGenre = "History";
                    break;
                case 27:
                    addGenre = "Horror";
                    break;
                case 10402:
                    addGenre = "Music";
                    break;
                case 9648:
                    addGenre = "Mystery";
                    break;
                case 10749:
                    addGenre = "Romance";
                    break;
                case 878:
                    addGenre = "Sci-Fi";
                    break;
                case 10770:
                    addGenre = "TV Movie";
                    break;
                case 53:
                    addGenre = "Thriller";
                    break;
                case 10752:
                    addGenre = "War";
                    break;
                case 37:
                    addGenre = "Western";
                    break;
                default:
                    break;
            }

            //  Add decoded genre
            movieGenres += addGenre;

            //  Add comma (except last one)
            if( i+1!=genreIds.size() ){
                movieGenres += ", ";
            }
        }

        //  Return final string of all genres
        return movieGenres;
    }
}
