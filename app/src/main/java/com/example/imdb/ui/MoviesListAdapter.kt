package com.example.imdb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdb.Constants
import com.example.imdb.model.Movie
import com.example.imdb.databinding.MoviesItemLayoutBinding


class MoviesListAdapter(private val onClick: (movie: Movie)-> Unit) : RecyclerView.Adapter<MovieViewHolder>() {
  private var movieList: List<Movie> = ArrayList<Movie>();


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
    val binding = MoviesItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return MovieViewHolder(binding)
  }

  override fun getItemCount(): Int {
    return movieList.size
  }

  override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    holder.bind(movieList.get(position), onClick)
  }

  fun update(newlist: List<Movie>){
    movieList = newlist
    notifyDataSetChanged()
    // diff util would be better
  }

  override fun getItemId(position: Int): Long {
    return (movieList[position].id?:0).toLong()
  }
}

class MovieViewHolder (val binding: MoviesItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
  fun bind(movie: Movie, onClick: (movie: Movie)-> Unit) {
    binding.apply {
      movieTitleTv.text = movie.title
      overviewTv.text = movie.overview
      Glide.with(itemView.context)
        .load(Constants.THUMBNAIL_ENDPOINT + movie.posterPath)
        .into(thumbnailIv)
      root.setOnClickListener { onClick.invoke(movie) }
    }
  }

}