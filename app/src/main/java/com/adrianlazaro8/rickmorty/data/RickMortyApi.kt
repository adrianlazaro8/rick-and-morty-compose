package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyApi {

    @GET("api/character")
    fun getAllCharacters(): PaginatedResult<Character>

    @GET("api/character/{id}")
    fun getSingleCharacter(@Path("id") id: String)

    @GET("api/character/")
    fun filteredCharacters(
        @Query("name") name: String,
        @Query("status") status: String,
        @Query("species") species: String,
        @Query("type") type: String,
        @Query("gender") gender: String
    ): PaginatedResult<Character>

    @GET("api/location")
    fun getAllLocations(): PaginatedResult<Location>

    @GET("api/location/{id}")
    fun getSingleLocation(@Path("id") id: String): Location

    @GET("api/location/")
    fun getFilteredLocations(
        @Query("name") name: String,
        @Query("type") type: String,
        @Query("dimension") dimension: String
    ): PaginatedResult<Location>

    @GET("api/episode")
    fun getAllEpisodes(): PaginatedResult<Episode>

    @GET("api/episode/{id}")
    fun getSingleEpisode(@Path("id") id: String): Episode

    @GET("api/episode/")
    fun getFilteredLocations(
        @Query("name") name: String,
        @Query("episode") episode: String
    ): PaginatedResult<Episode>

}