package com.adrianlazaro8.rickmorty.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.adrianlazaro8.rickmorty.data.remote.RemoteDataSource
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class LocationsRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getAllLocations(): Either<Error, PaginatedResult<List<Location>>> {

        val response = remoteDataSource.getAllLocations()
        response.fold(ifLeft = {
            return it.left()
        }) {
            return PaginatedResult(
                it.info,
                it.results.toDomainLocationList()
            ).right()
        }
    }
}