package com.sbaiardi.cleanexampleandroid.ui.presentation.screen.home.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sbaiardi.cleanexampleandroid.ui.AppContentColor
import com.sbaiardi.cleanexampleandroid.ui.AppThemeColor
import com.sbaiardi.cleanexampleandroid.ui.presentation.viewmodels.MovieDetailViewModel

@Composable
fun MovideDetailsScreen(
    movieId: String,
    navController: NavController,
    viewModel: MovieDetailViewModel = hiltViewModel()
){
    viewModel.getMovieDetails(movieID = movieId.toInt())
    val movieDetails by viewModel.selectedMovie.collectAsState()
    Scaffold(
        contentColor = MaterialTheme.colors.AppContentColor,
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        content = {
            movieDetails?.let {
                MovieDetailsContent(it, navController = navController)
            }
        }
    )
}