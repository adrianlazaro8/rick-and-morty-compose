package com.adrianlazaro8.rickmorty.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adrianlazaro8.rickmorty.ui.theme.RickMortyTheme

@Composable
fun RickMortyApp(content: @Composable () -> Unit) {
    RickMortyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}