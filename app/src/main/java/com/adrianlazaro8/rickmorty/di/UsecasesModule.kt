package com.adrianlazaro8.rickmorty.di

import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.data.LocationsRepository
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import com.adrianlazaro8.rickmorty.usecases.GetAllLocations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UsecasesModule {

    @Provides
    fun provideGetAllCharacter(charactersRepository: CharactersRepository) =
        GetAllCharacters(charactersRepository)

    @Provides
    fun provideGetAllLocations(locationsRepository: LocationsRepository) =
        GetAllLocations(locationsRepository)

}