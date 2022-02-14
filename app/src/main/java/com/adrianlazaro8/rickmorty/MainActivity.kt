package com.adrianlazaro8.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.adrianlazaro8.rickmorty.ui.RickMortyApp
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersScreen
import com.adrianlazaro8.rickmorty.ui.screens.characters.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyApp {
                CharactersScreen(
                    loading = viewModel.state.loading,
                    characters = viewModel.state.characters
                )
            }
        }
    }
}