package com.sbaiardi.data.repository.datasourceImpl

import com.sbaiardi.data.db.MovieDao
import com.sbaiardi.data.repository.datasource.MovieLocalDataSource
import com.sbaiardi.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override fun getMoviesFromLocalStorage(movieId: Int): Flow<Movie> = movieDao.getMovie(movieId)
}