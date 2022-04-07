package com.sbaiardi.data.repository.datasourceImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sbaiardi.data.api.MovieApi
import com.sbaiardi.data.db.MovieDB
import com.sbaiardi.data.paging.MovieRemoteMediator
import com.sbaiardi.data.repository.datasource.MovieRemoteDataSource
import com.sbaiardi.domain.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSourceImpl(private val movieApi: MovieApi, private val movieDB: MovieDB) :
    MovieRemoteDataSource {
    private val movieDao = movieDB.movieDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getRemoteMovies(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = { movieDao.getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(
                movieApi,
                movieDB
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}