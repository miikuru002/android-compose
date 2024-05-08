package com.example.moviecompose.database.factories

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviecompose.database.entities.MovieEntity
import com.example.moviecompose.database.dao.IMovieDao

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): IMovieDao
}