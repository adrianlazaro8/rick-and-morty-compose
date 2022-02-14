package com.adrianlazaro8.rickmorty.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.CharacterStatus
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.Origin

@Composable
fun CharacterListItem(
    character: Character
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(200.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = character.image),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = character.name,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = character.gender,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Preview
@Composable
fun CharacterListItemPreview() {
    val character = Character(
        1,
        "test",
        CharacterStatus.Alive,
        "asda",
        "asdasd",
        "asdasd",
        Origin("asdasd", "asdad"),
        Location(12, "asda", "asda", "asdasd", listOf(), "", ""),
        "",
        listOf(),
        "",
        ""
    )
    CharacterListItem(character = character)
}