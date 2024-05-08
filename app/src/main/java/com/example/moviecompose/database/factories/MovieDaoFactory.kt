package com.example.moviecompose.database.factories

import com.example.moviecompose.MyApplication
import com.example.moviecompose.database.dao.IMovieDao

class MovieDaoFactory private constructor() {
    companion object {
        private var movieDao: IMovieDao? = null

        fun getMovieDao(): IMovieDao {
            if (movieDao == null) {
                movieDao = AppDatabaseFactory.getAppDatabase(MyApplication.getContext()).movieDao()
            }
            return movieDao as IMovieDao
        }
    }
}