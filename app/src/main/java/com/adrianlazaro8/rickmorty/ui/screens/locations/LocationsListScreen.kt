package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import arrow.core.Either
import com.adrianlazaro8.rickmorty.R
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.ui.common.*

@Composable
fun LocationsListScreen(
    loading: Boolean,
    locations: Either<Error, PaginatedResult<List<Location>>?>
) {

    if (loading) {
        CircularProgressBarView()
    }

    locations.fold(
        ifLeft = { error ->
            ErrorView(error)
        },
        ifRight = {
            it?.let { paginatedLocations ->
                if (paginatedLocations.results.isNotEmpty()) {
                    LazyVerticalGridWithHeader(
                        title = stringResource(id = R.string.locations),
                        count = paginatedLocations.results.count(),
                        1,
                        spacedBy = 16.dp,
                        gridItem = { LocationListItem(paginatedLocations.results[it], it + 1) })
                }
            }
        }
    )

}
