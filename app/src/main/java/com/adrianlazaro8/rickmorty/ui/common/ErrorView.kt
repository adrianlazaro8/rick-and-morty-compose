package com.adrianlazaro8.rickmorty.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.adrianlazaro8.rickmorty.domain.Error

@Composable
fun ErrorView(error: Error) {

    val message = when (error) {
        Error.Connectivity -> "There is a connectivity problem"
        is Error.Server -> "There is a server error: ${error.code}}"
        is Error.Unknown -> "Unknown error: ${error.message}"
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            message
        )
    }
}