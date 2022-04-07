package com.sbaiardi.cleanexampleandroid.di

import com.sbaiardi.domain.repository.MovieRepository
import com.sbaiardi.domain.usecase.GetMoviesFromLocalStorageUseCase
import com.sbaiardi.domain.usecase.GetRemoteMoviesUseCase
import com.sbaiardi.domain.usecase.MovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideMovieUseCases(movieRepository: MovieRepository) = MovieUseCases(
        getRemoteMovies = GetRemoteMoviesUseCase(movieRepository = movieRepository),
        getMoviesFromDBUseCase = GetMoviesFromLocalStorageUseCase(movieRepository = movieRepository)
    )
}