package com.adrianlazaro8.rickmorty.di

import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
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

}