package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.usecases.GetAllLocations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val getAllLocations: GetAllLocations
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    init {
        getAllLocations()
    }

    private fun getAllLocations() = viewModelScope.launch {
        state = UiState(loading = true)
        state = UiState(locations = getAllLocations.invoke())
    }


    data class UiState(
        val loading: Boolean = false,
        val locations: Either<Error, PaginatedResult<List<Location>>?> = Either.Right(null)
    )
}