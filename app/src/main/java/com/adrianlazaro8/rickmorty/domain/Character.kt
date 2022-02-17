package com.adrianlazaro8.rickmorty.domain

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String
)
