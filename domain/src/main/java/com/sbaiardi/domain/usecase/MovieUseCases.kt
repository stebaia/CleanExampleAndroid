package com.sbaiardi.domain.usecase

data class MovieUseCases(
    val getRemoteMovies: GetRemoteMoviesUseCase,
    val getMoviesFromDBUseCase: GetMoviesFromLocalStorageUseCase,
)