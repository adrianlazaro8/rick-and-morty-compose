package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.ui.common.CharacterListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    characters: List<Character>
) {
    if (characters.isNotEmpty()) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        )
        {
            items(characters.size) { index ->
                CharacterListItem(character = characters[index])
            }
        }
    }
}