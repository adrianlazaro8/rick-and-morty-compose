package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.compose.runtime.Composable
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

@Composable
fun LocationsScreen(
    loading: Boolean,
    characters: Either<Error, PaginatedResult<List<Location>>?>
) {

}