package com.adrianlazaro8.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adrianlazaro8.rickmorty.ui.RickMortyApp
import com.adrianlazaro8.rickmorty.ui.navigation.MainNavigationItem
import com.adrianlazaro8.rickmorty.ui.navigation.Navigation
import com.adrianlazaro8.rickmorty.ui.screens.MainContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyApp {
                MainContent()
            }
        }
    }
}