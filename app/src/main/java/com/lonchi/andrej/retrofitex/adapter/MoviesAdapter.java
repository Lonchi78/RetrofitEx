package com.lonchi.andrej.retrofitex.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lonchi.andrej.retrofitex.R;
import com.lonchi.andrej.retrofitex.activity.MovieActivity;
import com.lonchi.andrej.retrofitex.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int itemLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        //RelativeLayout moviesLayoutOut;
        //LinearLayout moviesLayout;
        ImageView movieImage;
        TextView movieTitle;
        CardView cardView;
        //TextView data;
        //TextView movieDescription;
        //TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            //moviesLayoutOut = (RelativeLayout) v.findViewById(R.id.movies_layout_out);
            //moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieImage = (ImageView) v.findViewById(R.id.movie_image);
            movieTitle = (TextView) v.findViewById(R.id.title);
            cardView = (CardView) v.findViewById(R.id.cardview_layout);
            //data = (TextView) v.findViewById(R.id.subtitle);
            //movieDescription = (TextView) v.findViewById(R.id.description);
            //rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public MoviesAdapter(List<Movie> movies, int itemLayout, Context context) {
        this.movies = movies;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        //holder.data.setText(movies.get(position).getReleaseDate());
        //  Chnage description to genres!
        //holder.movieDescription.setText(movies.get(position).getOverview());
        //holder.rating.setText(String.valueOf(movies.get(position).getVoteAverage()));
        Glide.with(context).load(movies.get(position).getPosterUrl(2)).into(holder.movieImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Create new acitivity intent
                Intent intentMovieActivity = new Intent(context, MovieActivity.class);

                //  Pass data to new activity
                intentMovieActivity.putExtra("Title", movies.get(position).getTitle());
                intentMovieActivity.putExtra("Object", movies.get(position));

                //  Start the activity
                context.startActivity(intentMovieActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
