package com.adrianlazaro8.rickmorty.ui.screens.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.adrianlazaro8.rickmorty.R
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.ui.common.CharacterListItem
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersListScreen(
    paginatedCharacters: Flow<PagingData<Character>>,
    onClick: (Character) -> Unit
) {

    val charactersList = paginatedCharacters.collectAsLazyPagingItems()

    Column(
        modifier = Modifier.padding(start = 6.dp, end = 6.dp)
    ) {
        Text(
            text = stringResource(R.string.characters),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        )
        {
            items(charactersList.itemCount) { index ->
                charactersList[index]?.let {
                    CharacterListItem(
                        character = it,
                        onClick
                    )
                }
            }
            charactersList.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        //You can add modifier to manage load state when first time response page is loading
                    }
                    loadState.append is LoadState.Loading -> {
                        //You can add modifier to manage load state when next response page is loading
                    }
                    loadState.append is LoadState.Error -> {
                        //You can use modifier to show error message
                    }
                }
            }
        }
    }

}

//    LazyColumn {
//        items(charactersList){ item ->
//            item?.let {
//                LazyVerticalGridWithHeader(
//                    title = stringResource(id = R.string.characters),
//                    count = charactersList.itemCount,
//                    2,
//                    gridItem = { CharacterListItem(character = paginatedCharacters.results[it]) })
//            }
//        }
//}

//    if (loading) {
//        CircularProgressBarView()
//    }
//
//    characters.fold(
//        ifLeft = { error ->
//            ErrorView(error)
//        },
//        ifRight = {
//            it?.let { paginatedCharacters ->
//                if (paginatedCharacters.results.isNotEmpty()) {
//                    LazyVerticalGridWithHeader(
//                        title = stringResource(id = R.string.characters),
//                        count = paginatedCharacters.results.count(),
//                        2,
//                        gridItem = { CharacterListItem(character = paginatedCharacters.results[it]) })
//                }
//            }
//        }
//    )
//}