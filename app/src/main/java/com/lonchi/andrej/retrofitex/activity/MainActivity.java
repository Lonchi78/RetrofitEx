package com.lonchi.andrej.retrofitex.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lonchi.andrej.retrofitex.R;
import com.lonchi.andrej.retrofitex.model.Movie;
import com.lonchi.andrej.retrofitex.model.MovieResponse;
import com.lonchi.andrej.retrofitex.rest.ApiClient;
import com.lonchi.andrej.retrofitex.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "KEVINRETRO";

    //  My API key!
    private final static String API_KEY = "02969fad51f28d73966e923535eb424a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Tvorba klienta a nadviazanie spojenia
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        //  Create call request
        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        //  Catch request
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = null;
                if (response.body() != null) {
                    movies = response.body().getResults();
                    Log.d(TAG, "Number of movies received: " + movies.size());
                }else{
                    Log.d(TAG, "Empty body!");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                //  Error
                Log.d(TAG, t.toString());
            }
        });
    }
}
