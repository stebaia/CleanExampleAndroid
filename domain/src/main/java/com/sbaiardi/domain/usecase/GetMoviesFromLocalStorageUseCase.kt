package com.sbaiardi.domain.usecase

import com.sbaiardi.domain.repository.MovieRepository

class GetMoviesFromLocalStorageUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(movieId: Int) = movieRepository.getMoviesLocalMovies(movieId)
}