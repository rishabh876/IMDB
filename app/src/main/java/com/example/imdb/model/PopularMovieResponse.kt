package com.example.imdb.model

import com.google.gson.annotations.SerializedName

class PopularMovieResponse(@SerializedName("results") val results: List<Movie>)