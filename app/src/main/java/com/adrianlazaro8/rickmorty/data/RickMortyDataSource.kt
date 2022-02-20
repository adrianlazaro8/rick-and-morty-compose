package com.adrianlazaro8.rickmorty.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.domain.Error

class RickMortyDataSource(private val rickMortyApi: RickMortyApi) : RemoteDataSource {

    override suspend fun getAllCharacters(): Either<Error, PaginatedResult<List<CharacterDto>>> {
        return try {
            rickMortyApi.getAllCharacters().right()
        } catch (e: Exception) {
            Error.Unknown(e.toString()).left()
        }
    }

    override suspend fun getSingleCharacter(id: String): Either<Error, CharacterDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllLocations(): Either<Error, PaginatedResult<Location>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleLocation(id: String): Either<Error, Location> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllEpisodes(): Either<Error, PaginatedResult<Episode>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleEpisode(id: String): Either<Error, Episode> {
        TODO("Not yet implemented")
    }
}