package com.adrianlazaro8.rickmorty.ui.screens.locations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LocationsScreen(
    locationsViewModel: LocationsViewModel = hiltViewModel()
) {
    LocationsListScreen(
        locationsViewModel.state.loading,
        locationsViewModel.state.locations
    )
}