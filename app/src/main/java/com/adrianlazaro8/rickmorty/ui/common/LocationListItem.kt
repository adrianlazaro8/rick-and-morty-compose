package com.adrianlazaro8.rickmorty.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adrianlazaro8.rickmorty.domain.Location

@Composable
fun LocationListItem(location: Location, position: Int) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .height(50.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
            ) {
                Text(
                    text = position.toString(),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(Alignment.CenterVertically),
                )
            }
            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(top = 6.dp, bottom = 12.dp)
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(
                modifier = Modifier
                    .weight(8f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = location.name,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}