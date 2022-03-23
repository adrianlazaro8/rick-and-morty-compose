package com.adrianlazaro8.rickmorty.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalGridWithHeader(
    title: String,
    count: Int,
    gridCellsCount: Int = 1,
    gridItem: @Composable (Int) -> Unit
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(start = 10.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(gridCellsCount)
        )
        {
            items(count) { index ->
                gridItem(index)
            }
        }
    }
}