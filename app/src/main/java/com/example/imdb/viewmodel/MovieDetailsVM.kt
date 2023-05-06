package com.example.imdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb.repository.MoviesRepo
import com.example.imdb.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsVM @Inject constructor(private val moviesRepo: MoviesRepo,
                                         private val savedStateHandle: SavedStateHandle) : ViewModel() {
  private val id: Int = savedStateHandle.get<Int>("id") ?: 0

  var movie: MutableLiveData<Movie?> = MutableLiveData()

  init {
    viewModelScope.launch {
      movie.value = moviesRepo.getById(id)
    }
  }

}