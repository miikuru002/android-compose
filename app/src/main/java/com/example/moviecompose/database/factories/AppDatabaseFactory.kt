package com.example.moviecompose.database.factories

import android.content.Context
import androidx.room.Room

class AppDatabaseFactory private constructor() {
    companion object {
        private var db: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (db == null) {
                db = Room
                    .databaseBuilder(context, AppDatabase::class.java, "movie_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return db as AppDatabase
        }
    }
}