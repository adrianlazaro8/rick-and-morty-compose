package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class CharactersRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getAllCharacters(): PaginatedResult<List<Character>> {
        val response = remoteDataSource.getAllCharacters()
        return PaginatedResult(
            response.info,
            response.results.toDomainCharacterList()
        )
    }
}