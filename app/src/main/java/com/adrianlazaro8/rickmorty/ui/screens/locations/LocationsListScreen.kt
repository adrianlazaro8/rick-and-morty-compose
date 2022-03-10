package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

@Composable
fun LocationsListScreen(
    loading: Boolean,
    locations: Either<Error, PaginatedResult<List<Location>>?>
) {

    Box() {
        Text(text = "locations")
    }

}
