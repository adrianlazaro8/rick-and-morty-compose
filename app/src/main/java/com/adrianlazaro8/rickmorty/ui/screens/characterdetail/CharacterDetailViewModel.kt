package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters,
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val loading: Boolean = false,
        val characters: Either<Error, Character?> = Either.Right(null)
    )
}