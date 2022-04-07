package com.sbaiardi.data.repository.datasource

import androidx.paging.PagingData
import com.sbaiardi.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    fun getRemoteMovies(): Flow<PagingData<Movie>>
}