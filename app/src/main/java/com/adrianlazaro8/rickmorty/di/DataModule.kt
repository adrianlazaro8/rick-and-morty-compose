package com.adrianlazaro8.rickmorty.di

import android.content.Context
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.data.LocationsRepository
import com.adrianlazaro8.rickmorty.data.RickMortyApi
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.data.remote.RickMortyDataSource
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
    fun provideLocationsRepository(remoteDataSource: RemoteDataSource) =
        LocationsRepository(remoteDataSource)

    @Provides
    @Singleton
    fun provideApiService(@ApplicationContext context: Context): RickMortyApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .client(provideOkHttpClient(context))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(RickMortyApi::class.java)
    }

    private fun provideOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideChuckerInterceptor(context))
            .build()
    }

    private fun provideChuckerInterceptor(context: Context): ChuckerInterceptor {
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        return ChuckerInterceptor.Builder(context)
            .alwaysReadResponseBody(true)
            .build()
    }
}
