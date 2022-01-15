package com.example.tp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    public static final String apiURL = "https://api.themoviedb.org/3/";

    public static final String apiKey = "b0a2adadc1a130fa5e049805023f83bd";

    @GET("movie/popular?api_key="+apiKey)
    Call<Films> listMovies(@Query("language") String language, @Query("page") int page);

    @GET("movie/upcoming?api_key="+apiKey)
    Call<Films> upcomingMovies(@Query("language") String language, @Query("page") int page);

    @GET("genre/movie/list?api_key="+apiKey)
    Call<Catégories> listGenres();

    @GET("search/movie?api_key="+apiKey)
    Call<Films> moviesSearch(@Query("query") String query, @Query("language") String language);
}