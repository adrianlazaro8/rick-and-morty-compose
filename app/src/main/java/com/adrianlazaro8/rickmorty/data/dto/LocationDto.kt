package com.adrianlazaro8.rickmorty.data.dto

data class LocationDto(
    val id: Int?,
    val name: String,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?,
    val url: String
)
