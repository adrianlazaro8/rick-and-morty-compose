package com.adrianlazaro8.rickmorty.usecases

interface UseCase<T> {
    fun invoke(): T
}