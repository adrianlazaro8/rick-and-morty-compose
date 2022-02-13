package com.adrianlazaro8.rickmorty.usecases

import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class GetAllCharacters(private val charactersRepository: CharactersRepository) :
    UseCase<PaginatedResult<List<Character>>> {

    override suspend fun invoke(): PaginatedResult<List<Character>> =
        charactersRepository.getAllCharacters()
}