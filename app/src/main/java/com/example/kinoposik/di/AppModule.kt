package com.example.kinoposik.di

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kinoposik.R
import com.example.kinoposik.common.Constants.BASE_URL
import com.example.kinoposik.data.remote.MovieApi
import com.example.kinoposik.data.repository.MovieRepositoryImpl
import com.example.kinoposik.domain.repository.MovieRepository
import com.example.kinoposik.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Glide.with(androidApplication()).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
    single {
        MovieRepositoryImpl(api = get())
    }
    viewModel {
        MainViewModel(repository = get())
    }
}