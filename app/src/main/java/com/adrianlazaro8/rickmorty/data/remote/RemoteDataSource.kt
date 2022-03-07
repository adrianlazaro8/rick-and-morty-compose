package com.adrianlazaro8.rickmorty.data.remote

import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import com.adrianlazaro8.rickmorty.domain.Error

interface RemoteDataSource {

    suspend fun getAllCharacters(): Either<Error, PaginatedResult<List<CharacterDto>>>
    suspend fun getSingleCharacter(id: String): Either<Error, CharacterDto>
    suspend fun getAllLocations(): Either<Error, PaginatedResult<List<LocationDto>>>
    suspend fun getSingleLocation(id: String): Either<Error, Location>
    suspend fun getAllEpisodes(): Either<Error, PaginatedResult<Episode>>
    suspend fun getSingleEpisode(id: String): Either<Error, Episode>
}
