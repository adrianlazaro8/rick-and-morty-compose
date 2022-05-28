package com.adrianlazaro8.rickmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adrianlazaro8.rickmorty.ui.screens.characterdetail.CharacterDetailScreen
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersScreen
import com.adrianlazaro8.rickmorty.ui.screens.locations.LocationsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.CHARACTERS.route
    ) {
        composable(Screens.CHARACTERS.route) {
            CharactersScreen {
                navController.navigate(
                    Screens.CHARACTERS_DETAIL.route.replace(
                        "{id}",
                        it.id.toString()
                    )
                )
            }
        }
        composable(Screens.CHARACTERS_DETAIL.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            CharacterDetailScreen(id = it.arguments?.getString("id") ?: "")
        }
        composable(Screens.LOCATIONS.route) {
            LocationsScreen()
        }
    }
}