package com.adrianlazaro8.rickmorty.ui.screens.characterdetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import arrow.core.Either
import coil.compose.rememberImagePainter
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
                AnimatedVisibility(visible = true) {
                    Box {
                        Card(
                            elevation = 10.dp,
                            modifier = Modifier
                                .height(300.dp)
                                .padding(4.dp)
                                .fillMaxWidth()
                        ) {
                            Image(
                                painter = rememberImagePainter(data = character.image),
                                contentDescription = character.name,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                        //Footer with box containig character info
                    }
                }
            }

        }
    )
}