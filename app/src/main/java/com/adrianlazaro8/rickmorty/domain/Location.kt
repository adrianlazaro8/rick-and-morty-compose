package com.adrianlazaro8.rickmorty.domain

data class Location(
    val id: Int?,
    val name: String,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?,
    val url: String,
    val created: String?
)
