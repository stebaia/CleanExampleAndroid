package com.sbaiardi.cleanexampleandroid.di

import com.sbaiardi.data.repository.MovieRepositoryImpl
import com.sbaiardi.data.repository.datasource.MovieLocalDataSource
import com.sbaiardi.data.repository.datasource.MovieRemoteDataSource
import com.sbaiardi.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMoviesRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource
    ): MovieRepository =
        MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource = movieLocalDataSource)
}