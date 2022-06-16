package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error

class GetSingleCharacter(private val charactersRepository: CharactersRepository) :
    UseCaseInputParam<String, Character?> {

    override suspend operator fun invoke(characterId: String): Either<Error, Character?> =
        charactersRepository.getSingleCharacter(characterId)
}