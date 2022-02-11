package com.adrianlazaro8.rickmorty.di

import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.data.RickMortyApi
import com.adrianlazaro8.rickmorty.data.RickMortyDataSource
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()

        return retrofit.create(RickMortyApi::class.java)
    }
}
