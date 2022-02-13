package com.adrianlazaro8.rickmorty.usecases

interface UseCase<T> {
    suspend fun invoke(): T
}