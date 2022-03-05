package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class GetAllCharacters(private val charactersRepository: CharactersRepository) :
    UseCase<PaginatedResult<List<Character>>?> {

    override suspend fun invoke(): Either<Error, PaginatedResult<List<Character>>?> =
        charactersRepository.getAllCharacters()
}