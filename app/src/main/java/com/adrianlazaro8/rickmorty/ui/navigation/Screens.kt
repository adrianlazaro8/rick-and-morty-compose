package com.adrianlazaro8.rickmorty.ui.navigation

enum class Screens(val route: String) {
    CHARACTERS("characters"),
    LOCATIONS("locations"),
    CHARACTERS_DETAIL("characters/detail/{id}")
}