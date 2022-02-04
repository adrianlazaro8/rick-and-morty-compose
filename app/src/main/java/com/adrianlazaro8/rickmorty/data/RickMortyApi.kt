package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.domain.Character
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyApi {

    @GET("api/character")
    fun getAllCharacters(): List<Character>

    @GET("api/character/{id}")
    fun getSingleCharacter(@Path("id") id: String)

    @GET("api/character/")
    fun filterCharacters(@Query("name") name: String, @Query("status") status: String)
}