package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.adrianlazaro8.rickmorty.domain.Character
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun getAllCharacters() {
        viewModelScope.launch {
            state = UiState(loading = true)
            val result = getAllCharacters.invoke()
            state = UiState(characters = result.results)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val characters: List<Character> = listOf()
    )
}