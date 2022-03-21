package com.adrianlazaro8.rickmorty.data.remote

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.adrianlazaro8.rickmorty.data.RickMortyApi
import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.domain.*

class RickMortyDataSource(private val rickMortyApi: RickMortyApi) : RemoteDataSource {

    override suspend fun getAllCharacters(): Either<Error, PaginatedResult<List<CharacterDto>>> {
        return try {
            rickMortyApi.getAllCharacters().right()
        } catch (e: Exception) {
            e.toError(e.localizedMessage ?: "").left()
        }
    }

    override suspend fun getSingleCharacter(id: String): Either<Error, CharacterDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllLocations(): Either<Error, PaginatedResult<List<LocationDto>>> {
        return try {
            rickMortyApi.getAllLocations().right()
        } catch (e: Exception) {
            e.toError(e.localizedMessage ?: "").left()
        }
    }

    override suspend fun getSingleLocation(id: String): Either<Error, LocationDto> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllEpisodes(): Either<Error, PaginatedResult<Episode>> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleEpisode(id: String): Either<Error, Episode> {
        TODO("Not yet implemented")
    }
}