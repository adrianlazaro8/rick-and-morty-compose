package com.adrianlazaro8.rickmorty.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainNavigationItem(
    val title: String,
    val icon: ImageVector,
    val navigationItem: NavigationItem,
) {

    CHARACTERS(
        Screens.CHARACTERS.toString(),
        Icons.Default.Person,
        NavigationItem.ContentType(Screens.CHARACTERS)
    ),
    LOCATIONS(
        Screens.LOCATIONS.toString(),
        Icons.Default.Place,
        NavigationItem.ContentType(Screens.LOCATIONS)
    )
}

sealed class NavigationItem(
    val screen: Screens,
    val subScreen: String = "main"
) {

    class ContentType(screen: Screens) : NavigationItem(screen)
}