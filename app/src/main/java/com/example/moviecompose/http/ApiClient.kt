package com.example.moviecompose.http

import com.example.moviecompose.services.IMovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun createMovieService(): IMovieService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMovieService::class.java)
    }
}