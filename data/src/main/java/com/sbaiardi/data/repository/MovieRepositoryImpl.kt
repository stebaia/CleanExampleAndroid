package com.sbaiardi.data.repository

import androidx.paging.PagingData
import com.sbaiardi.data.repository.datasource.MovieLocalDataSource
import com.sbaiardi.data.repository.datasource.MovieRemoteDataSource
import com.sbaiardi.domain.model.Movie
import com.sbaiardi.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) :
    MovieRepository {
    override fun getRemoteMovies(): Flow<PagingData<Movie>> =
        movieRemoteDataSource.getRemoteMovies()

    override fun getMoviesLocalMovies(movieId: Int): Flow<Movie> =
        movieLocalDataSource.getMoviesFromLocalStorage(movieId)
}