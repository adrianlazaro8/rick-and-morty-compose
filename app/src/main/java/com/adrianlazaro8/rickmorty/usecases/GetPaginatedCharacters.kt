package com.adrianlazaro8.rickmorty.usecases

import androidx.paging.PagingData
import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.CharactersRepository
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import kotlinx.coroutines.flow.Flow

class GetPaginatedCharacters(private val charactersRepository: CharactersRepository) {

    fun invoke(): Flow<PagingData<Character>> =
        charactersRepository.getPagedCharacters()
}