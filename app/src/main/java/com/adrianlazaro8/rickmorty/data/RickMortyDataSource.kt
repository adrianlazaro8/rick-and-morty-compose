package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class RickMortyDataSource(private val rickMortyApi: RickMortyApi) : RemoteDataSource {

    override suspend fun getAllCharacters(): PaginatedResult<List<CharacterDto>> {
        return rickMortyApi.getAllCharacters()
    }

    override suspend fun getSingleCharacter(id: String): CharacterDto {
        TODO("Not yet implemented")
    }

    override suspend fun getAllLocations(): PaginatedResult<Location> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleLocation(id: String): Location {
        TODO("Not yet implemented")
    }

    override suspend fun getAllEpisodes(): PaginatedResult<Episode> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleEpisode(id: String): Episode {
        TODO("Not yet implemented")
    }
}