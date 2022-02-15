package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.adrianlazaro8.rickmorty.R
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.ui.common.CharacterListItem
import com.adrianlazaro8.rickmorty.ui.common.LazyVerticalGridWithHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    loading: Boolean,
    characters: List<Character>
) {
    if (loading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }
    if (characters.isNotEmpty()) {
        LazyVerticalGridWithHeader(
            title = stringResource(id = R.string.characters),
            count = characters.count(),
            gridItem = { CharacterListItem(character = characters[it]) })
    }
}