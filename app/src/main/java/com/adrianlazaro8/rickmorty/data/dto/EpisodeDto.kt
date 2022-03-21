package com.adrianlazaro8.rickmorty.data.dto

data class EpisodeDto(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
)
