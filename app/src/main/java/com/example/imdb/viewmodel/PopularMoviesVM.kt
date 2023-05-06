package com.example.imdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.repository.MoviesRepo
import com.example.imdb.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesVM @Inject constructor(private val moviesRepo: MoviesRepo) : ViewModel() {
  val popularMovies = MutableLiveData<List<Movie>>()

  init {
    viewModelScope.launch {
      val result = moviesRepo.getPopularMovies()
      popularMovies.value = result
    }
  }
}