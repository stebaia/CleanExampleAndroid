package com.sbaiardi.cleanexampleandroid.di


import com.sbaiardi.data.db.MovieDao
import com.sbaiardi.data.repository.datasource.MovieLocalDataSource
import com.sbaiardi.data.repository.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSourceImpl(movieDao = movieDao)
}