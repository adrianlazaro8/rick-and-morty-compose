package com.adrianlazaro8.rickmorty.di

import com.adrianlazaro8.rickmorty.data.RickMortyApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApiService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()

        retrofit.create(RickMortyApi::class.java)
    }
}
