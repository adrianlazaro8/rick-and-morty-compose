package com.adrianlazaro8.rickmorty.domain

data class PaginatedInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
)
