package com.sbaiardi.cleanexampleandroid.di

import com.sbaiardi.data.api.MovieApi
import com.sbaiardi.data.db.MovieDB
import com.sbaiardi.data.repository.datasource.MovieRemoteDataSource
import com.sbaiardi.data.repository.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideMoviesRemoteDataSource(movieApi: MovieApi, movieDB: MovieDB) : MovieRemoteDataSource =
        MovieRemoteDataSourceImpl(movieApi, movieDB = movieDB)
}