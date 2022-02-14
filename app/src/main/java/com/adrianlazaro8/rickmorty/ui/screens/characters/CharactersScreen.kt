package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrianlazaro8.rickmorty.R
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.CharacterStatus
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.Origin
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