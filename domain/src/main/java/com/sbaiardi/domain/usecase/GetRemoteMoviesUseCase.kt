package com.sbaiardi.domain.usecase

import com.sbaiardi.domain.repository.MovieRepository

class GetRemoteMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getRemoteMovies()
}