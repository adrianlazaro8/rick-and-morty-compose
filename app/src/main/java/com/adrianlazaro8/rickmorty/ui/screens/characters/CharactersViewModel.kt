package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

}