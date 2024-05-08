package com.example.moviecompose.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.moviecompose.model.dto.MovieResponseList
import com.example.moviecompose.services.MovieService

@Composable
fun TopRatedMoviesScreen(
    navController: NavController?,
    movieService: MovieService = MovieService()
) {
    val movies = remember {
        mutableStateOf(MovieResponseList(emptyList()))
    }

    movieService.getTopRatedMovies {
        movies.value = it
    }

    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(movies.value.results) { movie ->
                MovieItem(movie = movie)
            }
        }
    }
}