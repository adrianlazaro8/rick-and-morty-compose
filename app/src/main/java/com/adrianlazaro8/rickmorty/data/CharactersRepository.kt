package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource

class CharactersRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getAllCharacters() = remoteDataSource.getAllCharacters()
}