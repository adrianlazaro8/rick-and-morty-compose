package com.adrianlazaro8.rickmorty.data.dto

import com.adrianlazaro8.rickmorty.domain.CharacterStatus
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.Origin

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
