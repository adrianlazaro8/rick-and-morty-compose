package com.adrianlazaro8.rickmorty.domain

data class PaginatedResult<T>(
    val info: PaginatedInfo,
    val results: T
)
