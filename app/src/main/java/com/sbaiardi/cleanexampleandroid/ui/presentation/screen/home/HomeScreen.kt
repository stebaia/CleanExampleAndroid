package com.sbaiardi.cleanexampleandroid.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sbaiardi.cleanexampleandroid.ui.AppContentColor
import com.sbaiardi.cleanexampleandroid.ui.AppThemeColor
import com.sbaiardi.cleanexampleandroid.ui.presentation.screen.HomeTopBar
import com.sbaiardi.cleanexampleandroid.ui.presentation.screen.home.MovieListContent
import com.sbaiardi.cleanexampleandroid.ui.presentation.viewmodels.HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemeColor
    val allMovies = viewModel.getRemoteMovies.collectAsLazyPagingItems()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemeColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
            HomeTopBar()
        },
        content = {
            MovieListContent(allMovies = allMovies, navController = navController)
        }
    )
}
