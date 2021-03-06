package com.adrianlazaro8.rickmorty.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.adrianlazaro8.rickmorty.data.remote.CharactersPagingSource
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import kotlinx.coroutines.flow.Flow
import toDomainCharacter
import toDomainCharacterList

class CharactersRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getAllCharacters(): Either<Error, PaginatedResult<List<Character>>> {
        val response = remoteDataSource.getAllCharacters()
        return response.fold(ifLeft = {
            it.left()
        }) {
            PaginatedResult(
                it.info,
                it.results.toDomainCharacterList()
            ).right()
        }
    }

    suspend fun getSingleCharacter(id: String): Either<Error, Character> {
        val response = remoteDataSource.getSingleCharacter(id)
        return response.fold(
            ifLeft = {
                it.left()
            },
            ifRight = {
                it.toDomainCharacter().right()
            }
        )
    }

    fun getPagedCharacters(): Flow<PagingData<Character>> {
        return Pager(
            PagingConfig(pageSize = 20, prefetchDistance = 10)
        ) {
            CharactersPagingSource(remoteDataSource)
        }.flow
    }
}