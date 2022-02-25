package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import arrow.core.right
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(characters = getAllCharacters.invoke())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val characters: Either<Error, PaginatedResult<List<Character>>?> = Either.Right(null)
    )
}