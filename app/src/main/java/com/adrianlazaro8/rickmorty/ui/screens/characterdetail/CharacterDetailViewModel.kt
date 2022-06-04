package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersViewModel
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters,
) : ViewModel() {

    var state by mutableStateOf(CharactersViewModel.UiState())
        private set
}