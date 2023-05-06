package com.example.imdb.repository

import com.example.imdb.model.Movie

interface MoviesRepo {
  suspend fun getPopularMovies(): List<Movie>
  suspend fun getById(id: Int): Movie?
}