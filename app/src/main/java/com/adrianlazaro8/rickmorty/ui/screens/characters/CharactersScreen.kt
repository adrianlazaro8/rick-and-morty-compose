package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    characters: List<Character>
) {
    if (characters.isNotEmpty()) {
        Column {
            Text(
                text = stringResource(R.string.characters),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(start = 10.dp)
            )

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
}

@Preview
@Composable
fun CharactersScreenPreview() {
    val character = Character(
        1,
        "test",
        CharacterStatus.ALIVE,
        "asda",
        "asdasd",
        "asdasd",
        Origin("asdasd", "asdad"),
        Location(12, "asda", "asda", "asdasd", listOf(), "", ""),
        "",
        listOf(),
        "",
        ""
    )
    val listof = listOf(
        character, character, character
    )
    CharactersScreen(listof)
}