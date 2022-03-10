package com.adrianlazaro8.rickmorty.ui.screens

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
            BottomNavigation {
                MainNavigationItem.values().forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute.contains(item.navigationItem.screen.toString()),
                        onClick = {
                            navController.navigate(item.navigationItem.screen.toString())
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