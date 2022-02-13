package com.adrianlazaro8.rickmorty.di

import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.data.RickMortyApi
import com.adrianlazaro8.rickmorty.data.RickMortyDataSource
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(rickMortyApi: RickMortyApi): RemoteDataSource =
        RickMortyDataSource(rickMortyApi)

    @Provides
    @Singleton
    fun provideCharactersRepository(remoteDataSource: RemoteDataSource) =
        CharactersRepository(remoteDataSource)

    @Provides
    @Singleton
    fun provideApiService(): RickMortyApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(RickMortyApi::class.java)
    }
}
