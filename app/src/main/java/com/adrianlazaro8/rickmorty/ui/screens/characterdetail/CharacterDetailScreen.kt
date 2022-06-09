package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterDetailScreen(
    id: String = "",
    characterDetailViewModel: CharacterDetailViewModel = hiltViewModel()
) {

    CharacterDetailItemView(
        loading = characterDetailViewModel.state.loading,
        character = characterDetailViewModel.state.characters
    )

}