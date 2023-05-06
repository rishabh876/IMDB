package com.example.imdb.di

import android.content.Context
import com.example.imdb.data.LocalDataRepo
import com.example.imdb.data.MoviesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {
  @Provides
  fun getMoviesRepo(@ApplicationContext context: Context): MoviesRepo {
    return LocalDataRepo(context)
  }
}