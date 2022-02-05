package com.adrianlazaro8.rickmorty.data.remote

import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

interface RemoteDataSource {
    suspend fun getAllCharacters(): PaginatedResult<Character>
    suspend fun getSingleCharacter(id: String): Character
    suspend fun getAllLocations(): PaginatedResult<Location>
    suspend fun getSingleLocation(id: String): Location
    suspend fun getAllEpisodes(): PaginatedResult<Episode>
    suspend fun getSingleEpisode(id: String): Episode
}
