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
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.adrianlazaro8.rickmorty.domain.Location

@Composable
fun LocationListItem(location: Location) {
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
                painter = rememberImagePainter(data = location.url),
                contentDescription = location.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = location.name,
            style = MaterialTheme.typography.h3
        )
    }
}