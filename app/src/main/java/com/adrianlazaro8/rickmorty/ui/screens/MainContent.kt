package com.adrianlazaro8.rickmorty.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adrianlazaro8.rickmorty.ui.navigation.MainNavigationItem
import com.adrianlazaro8.rickmorty.ui.navigation.Navigation

@Composable
fun MainContent() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.background
            ) {
                MainNavigationItem.values().forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute.contains(item.navigationItem.screen.toString()),
                        onClick = {
                            navController.navigate(item.navigationItem.screen.toString()) {
                                popUpTo(navController.graph.findStartDestination().id)
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) {
        Navigation(navController)
    }
}