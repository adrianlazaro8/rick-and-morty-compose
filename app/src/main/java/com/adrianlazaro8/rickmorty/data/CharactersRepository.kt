package com.adrianlazaro8.rickmorty.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class CharactersRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getAllCharacters(): Either<Error, PaginatedResult<List<Character>>> {

        val response = remoteDataSource.getAllCharacters()
        response.fold(ifLeft = {
            return it.left()
        }) {
            return PaginatedResult(
                it.info,
                it.results.toDomainCharacterList()
            ).right()
        }
    }
}