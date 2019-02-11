package com.lonchi.andrej.retrofitex.rest;

import com.lonchi.andrej.retrofitex.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);
    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetail(@Path("id") int id, @Query("api_key") String apiKey);

    //  existuju aj ine mozne gety
}
