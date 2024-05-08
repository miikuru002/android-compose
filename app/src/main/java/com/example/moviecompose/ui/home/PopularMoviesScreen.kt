package com.example.moviecompose.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviecompose.http.ApiClient
import com.example.moviecompose.model.dto.MovieResponse
import com.example.moviecompose.model.dto.MovieResponseList
import com.example.moviecompose.services.IMovieService
import com.example.moviecompose.services.MovieService

@Composable
fun PopularMoviesScreen(
    navController: NavController?,
    movieService: MovieService = MovieService()
) {
    val movies = remember {
        mutableStateOf(MovieResponseList(emptyList()))
    }

    movieService.getPopularMovies() {
        movies.value = it
    }

    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(movies.value.results) { movie ->
                MovieItem(movie)
            }
        }
    }
}

@Composable
fun MovieItem(movie: MovieResponse, movieService: MovieService = MovieService()) {
    //estado para saber si la pelicula es favorita
    val isFavorite = remember {
        mutableStateOf(false)
    }

    //se guarda el estado de la pelicula en el estado isFavorite
    isFavorite.value = movie.isFavorite

    Card(modifier = Modifier.padding(4.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(3f),
                text = movie.title
            )
            IconButton(
                onClick = {
                    isFavorite.value = !isFavorite.value
                    movie.isFavorite = isFavorite.value

                    if (isFavorite.value) {
                        movieService.saveMovieAsFavorite(movie.id)
                    } else {
                        movieService.deleteFavoriteMovie(movie.id)
                    }
                }
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    tint = if (isFavorite.value) {
                        MaterialTheme.colorScheme.primary
                    } else Color.Gray
                )
            }
        }
    }
}
