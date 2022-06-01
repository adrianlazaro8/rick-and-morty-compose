package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrianlazaro8.rickmorty.domain.Character

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    charactersViewModel: CharactersViewModel = hiltViewModel(),
    onClick: (Character) -> Unit

) {
    CharactersListScreen(
        charactersViewModel.paginatedCharacters,
        onClick = {
            onClick(it)
        }
    )
}