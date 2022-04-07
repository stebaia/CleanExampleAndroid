package com.sbaiardi.cleanexampleandroid.ui.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.sbaiardi.domain.usecase.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    movieUseCases: MovieUseCases,
) : ViewModel() {
    val getRemoteMovies = movieUseCases.getRemoteMovies()

}