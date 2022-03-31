package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error

interface UseCase<T> {
    suspend fun invoke(): Either<Error, T>
}