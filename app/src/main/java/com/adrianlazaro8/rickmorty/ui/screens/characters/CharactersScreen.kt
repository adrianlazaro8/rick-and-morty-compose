package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import arrow.core.Either
import com.adrianlazaro8.rickmorty.R
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.ui.common.CharacterListItem
import com.adrianlazaro8.rickmorty.ui.common.LazyVerticalGridWithHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    loading: Boolean,
    characters: Either<Error, PaginatedResult<List<Character>>?>
) {
    if (loading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    characters.fold(
        ifLeft = {
            //TODO showErrorScreen
        },
        ifRight = {
            it?.let { paginatedCharacters ->
                if (paginatedCharacters.results.isNotEmpty()) {
                    LazyVerticalGridWithHeader(
                        title = stringResource(id = R.string.characters),
                        count = paginatedCharacters.results.count(),
                        gridItem = { CharacterListItem(character = paginatedCharacters.results[it]) })
                }
            }
        }
    )
}