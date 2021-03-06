package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import arrow.core.Either
import com.adrianlazaro8.rickmorty.usecases.GetAllCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.usecases.GetPaginatedCharacters
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters,
    private val getPaginatedCharacters: GetPaginatedCharacters
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

    val paginatedCharacters = getPaginatedCharacters.invoke().cachedIn(viewModelScope)


    data class UiState(
        val loading: Boolean = false,
        val characters: Either<Error, PaginatedResult<List<Character>>?> = Either.Right(null)
    )
}