package com.sbaiardi.domain.repository

import androidx.paging.PagingData
import com.sbaiardi.domain.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getRemoteMovies(): Flow<PagingData<Movie>>
    fun getMoviesLocalMovies(movieId: Int): Flow<Movie>
}