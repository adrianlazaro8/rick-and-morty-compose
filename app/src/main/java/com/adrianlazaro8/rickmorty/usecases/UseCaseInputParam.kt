package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.domain.Error

interface UseCaseInputParam<T, R> {

    suspend fun invoke(t: T): Either<Error, R>
}