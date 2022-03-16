package com.adrianlazaro8.rickmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersScreen
import com.adrianlazaro8.rickmorty.ui.screens.locations.LocationsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.CHARACTERS.toString()
    ) {
        composable(Screens.CHARACTERS.toString()) {
            CharactersScreen()
        }
        composable(Screens.LOCATIONS.toString()) {
            LocationsScreen()
        }
    }
}