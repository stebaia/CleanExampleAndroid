package com.sbaiardi.data.repository.datasource

import com.sbaiardi.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getMoviesFromLocalStorage(movieId: Int): Flow<Movie>
}