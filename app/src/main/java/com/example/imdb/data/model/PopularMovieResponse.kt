package com.example.imdb.data.model

import com.google.gson.annotations.SerializedName

class PopularMovieResponse(@SerializedName("results") val results: List<Movie>)