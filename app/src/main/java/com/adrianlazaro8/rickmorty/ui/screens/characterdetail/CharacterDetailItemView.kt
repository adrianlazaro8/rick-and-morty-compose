package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error

@Composable
fun CharacterDetailItemView(
    loading: Boolean,
    character: Either<Error, Character?>
) {

    if (loading) {
        //Show loading
    }

    character.fold(
        ifLeft = {

        },
        ifRight = {
            it?.let { character ->
                Box {
                    Text(text = character.name)
                    //Header nav
                    // Background image
                    //Footer with box containig character info
                }
            }

        }
    )
}