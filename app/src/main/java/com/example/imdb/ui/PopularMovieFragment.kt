package com.example.imdb.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.imdb.databinding.FragmentPopularMovieBinding
import com.example.imdb.viewmodel.PopularMoviesVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PopularMovieFragment : Fragment() {

  private lateinit var binding: FragmentPopularMovieBinding
  private val viewModel: PopularMoviesVM by viewModels<PopularMoviesVM>()
  private lateinit var adapter: MoviesListAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return FragmentPopularMovieBinding.inflate(inflater).let {
      binding = it
      it.root
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.moviesRv.adapter = MoviesListAdapter {
      findNavController().navigate(PopularMovieFragmentDirections.actionPopularMovieFragmentToMovieDetailsFragment(it.id?:0))
    }.also { adapter = it }

    viewModel.popularMovies.observe(viewLifecycleOwner) {
      Log.d("ListFragment", "List updated")
      adapter.update(it)
    }
  }
}