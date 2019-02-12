package com.lonchi.andrej.retrofitex.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    //  Base url for movie poster
    private static String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w";

    //  Variables
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("id")
    private int id;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private float voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("genre_ids")
    private List<Integer> genreIds = new ArrayList<Integer>();
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    //  TODO
    //  Original title is missing because String doesnt handle chinese etc. ...

    //  Constructor
    public Movie(int voteCount, int id, boolean video, float voteAverage, String title,
                 int popularity, String posterPath, String originalLanguage, List<Integer> genreIds,
                 String backdropPath, boolean adult, String overview, String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }


    //  Getters
    public int getVoteCount() {
        return voteCount;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }


    //  Setters
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    //  Custom methods
    public String getPosterUrl(int size) {
        /*
         *   Widths:
         *   92
         *   154
         *   185
         *   342
         *   500
         *   780
         * */
        String posterSize;

        switch (size){
            case 0:
                posterSize = "92";
                break;
            case 1:
                posterSize = "154";
                break;
            case 2:
                posterSize = "185";
                break;
            case 3:
                posterSize = "342";
                break;
            case 4:
                posterSize = "500";
                break;
            case 5:
                posterSize = "780";
                break;
            default:
                posterSize = "342";
        }

        return POSTER_BASE_URL+posterSize+posterPath;
    }

    public String getMovieGenres(){
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
