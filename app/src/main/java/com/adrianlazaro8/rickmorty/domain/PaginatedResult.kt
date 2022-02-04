package com.adrianlazaro8.rickmorty.domain

data class PaginatedResult<T>(
    val paginatedInfo: PaginatedInfo,
    val results: T
)
