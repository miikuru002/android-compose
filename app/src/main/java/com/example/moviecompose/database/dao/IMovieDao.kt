package com.example.moviecompose.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.moviecompose.database.entities.MovieEntity

/**
 * Se definen las operaciones que se pueden realizar sobre la tabla de restaurantes
 */
@Dao
interface IMovieDao {
    @Insert
    fun insert(movieEntity: MovieEntity)

    @Delete
    fun delete(movieEntity: MovieEntity)

    @Query("select * from movies where id=:id")
    fun fetchById(id: Int): MovieEntity?
}