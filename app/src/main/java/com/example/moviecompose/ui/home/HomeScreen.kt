package com.example.moviecompose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Routes(val route: String) {
    Popular(route = "Popular"),
    TopRated(route = "TopRated"),
    Upcoming(route = "Upcoming"),
}

@Composable
fun HomeScreen() {
    //create a list of tabs
    val tabIndex = remember {
        mutableIntStateOf(0)
    }
    val tabs = listOf("Popular", "Top Rated", "Upcoming")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex.intValue) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex.intValue == index,
                    onClick = { tabIndex.intValue = index }
                )
            }
        }

        when (tabIndex.intValue) {
            0 -> PopularMoviesScreen(null)
            1 -> TopRatedMoviesScreen(null)
            2 -> UpcomingMoviesScreen(null)
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Popular.route) {
        composable(Routes.Popular.route) {
            PopularMoviesScreen(navController)
        }
        composable(Routes.TopRated.route) {
            TopRatedMoviesScreen(navController)
        }
        composable(Routes.Upcoming.route) {
            UpcomingMoviesScreen(navController)
        }
    }
}