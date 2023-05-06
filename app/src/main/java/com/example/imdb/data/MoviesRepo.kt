package com.example.imdb.data

import com.example.imdb.data.model.Movie

interface MoviesRepo {
  suspend fun getPopularMovies(): List<Movie>
  suspend fun getById(id: Int): Movie?
}