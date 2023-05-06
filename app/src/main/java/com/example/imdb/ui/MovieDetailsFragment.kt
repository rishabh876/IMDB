package com.example.imdb.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.imdb.Constants
import com.example.imdb.R
import com.example.imdb.data.model.Movie
import com.example.imdb.databinding.FragmentMovieDetailsBinding
import com.example.imdb.viewmodel.MovieDetailsVM
import dagger.hilt.android.AndroidEntryPoint
import java.text.DateFormat
import java.util.Date

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
  private lateinit var binding: FragmentMovieDetailsBinding
  private val args: MovieDetailsFragmentArgs by navArgs()

  private val viewModel: MovieDetailsVM by viewModels<MovieDetailsVM>(extrasProducer = {
    MutableCreationExtras(defaultViewModelCreationExtras).apply {
      set(DEFAULT_ARGS_KEY, bundleOf("id" to args.id))
    }
  })

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.toolbar.setNavigationIcon(com.google.android.material.R.drawable.ic_arrow_back_black_24)
    binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    viewModel.movie.observe(viewLifecycleOwner) {
      onMovieUpdated(it)
    }
  }

  private fun onMovieUpdated(movie: Movie?) {
    if(movie!=null){
      binding.apply {
        Glide.with(thumbnailIv)
          .load(Constants.THUMBNAIL_ENDPOINT + movie.posterPath)
          .into(thumbnailIv)

        toolbar.title = movie.title
        overviewTv.text = movie.overview
        dateTv.text = movie.releaseDate?.replace("-", "/")
        ratingTv.text = movie.voteAverage.toString()
        popularityTv.text = movie.popularity.toString()
      }
    }
  }
}