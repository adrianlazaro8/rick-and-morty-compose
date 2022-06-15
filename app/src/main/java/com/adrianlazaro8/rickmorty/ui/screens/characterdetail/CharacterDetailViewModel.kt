package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersViewModel
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import com.adrianlazaro8.rickmorty.usecases.GetSingleCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSingleCharacter: GetSingleCharacter
) : ViewModel() {

    private val characterId = savedStateHandle.get<String>("id")
        ?: throw IllegalAccessException("CharacterId is required")

    var state by mutableStateOf(UiState())
        private set

    init {
        getSingleCharacter(characterId)
    }

    private fun getSingleCharacter(characterId: String) {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(characters = getSingleCharacter.invoke(characterId))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val characters: Either<Error, Character?> = Either.Right(null)
    )
}