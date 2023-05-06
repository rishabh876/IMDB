package com.example.imdb.data

import android.content.Context
import com.example.imdb.R
import com.example.imdb.data.model.Movie
import com.example.imdb.data.model.PopularMovieResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataRepo(private val context: Context) : MoviesRepo {

  override suspend fun getPopularMovies(): List<Movie> {
    val result = withContext(Dispatchers.IO) {

      val text = context.resources.openRawResource(R.raw.data)
        .bufferedReader().use { it.readText() }
      Gson().fromJson(text, PopularMovieResponse::class.java)
    }
    return result.results
  }

  override suspend fun getById(id: Int): Movie? {
    val result = withContext(Dispatchers.IO) {

      val text = context.resources.openRawResource(R.raw.data)
        .bufferedReader().use { it.readText() }
      val movies = Gson().fromJson(text, PopularMovieResponse::class.java).results
      movies.find { it.id == id }
    }
    return result
  }
}
