package com.example.moviecompose.services

import com.example.moviecompose.model.dto.MovieResponseList
import com.example.moviecompose.database.entities.MovieEntity
import com.example.moviecompose.database.dao.IMovieDao
import com.example.moviecompose.database.factories.MovieDaoFactory
import com.example.moviecompose.http.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieService(
    private val movieService: IMovieService = ApiClient.createMovieService(),
    private val movieDao: IMovieDao = MovieDaoFactory.getMovieDao()
) {
    fun getPopularMovies(callback: (MovieResponseList) -> Unit) {
        val call = movieService.getPopularMovies()

        call.enqueue(object : Callback<MovieResponseList> {
            override fun onResponse(call: Call<MovieResponseList>, response: Response<MovieResponseList>) {
                if (response.isSuccessful) {
                    val movies = response.body()!!
                    callback(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponseList>, t: Throwable) {
                t.message?.let {
                    println(it)
                }
            }
        })
    }

    fun getTopRatedMovies(callback: (MovieResponseList) -> Unit) {
        val call = movieService.getTopRatedMovies()

        call.enqueue(object : Callback<MovieResponseList> {
            override fun onResponse(call: Call<MovieResponseList>, response: Response<MovieResponseList>) {
                if (response.isSuccessful) {
                    val movies = response.body()!!
                    callback(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponseList>, t: Throwable) {
                t.message?.let {
                    println(it)
                }
            }
        })
    }

    fun getUpcomingMovies(callback: (MovieResponseList) -> Unit) {
        val call = movieService.getUpcomingMovies()

        call.enqueue(object : Callback<MovieResponseList> {
            override fun onResponse(call: Call<MovieResponseList>, response: Response<MovieResponseList>) {
                if (response.isSuccessful) {
                    val movies = response.body()!!
                    callback(movies)
                }
            }

            override fun onFailure(call: Call<MovieResponseList>, t: Throwable) {
                t.message?.let {
                    println(it)
                }
            }
        })
    }

    fun saveMovieAsFavorite(movieId: Int) {
        val entity = MovieEntity(id = movieId)
        movieDao.insert(entity)
    }

    fun deleteFavoriteMovie(movieId: Int) {
        val entity = MovieEntity(id = movieId)
        movieDao.delete(entity)
    }
}