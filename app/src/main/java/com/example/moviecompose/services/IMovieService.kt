package com.example.moviecompose.services

import com.example.moviecompose.model.dto.MovieResponseList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieService {
    @GET("popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"
    ): Call<MovieResponseList>

    @GET("top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"
    ): Call<MovieResponseList>

    @GET("upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325"
    ): Call<MovieResponseList>
}
