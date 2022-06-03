package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class GetSingleCharacter(private val charactersRepository: CharactersRepository) :
    UseCase<Character?> {

    override suspend fun invoke(): Either<Error, Character?> =
        charactersRepository.getSingleCharacter("1")
}