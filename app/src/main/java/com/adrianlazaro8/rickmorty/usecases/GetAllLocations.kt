package com.adrianlazaro8.rickmorty.usecases

import arrow.core.Either
import com.adrianlazaro8.rickmorty.data.LocationsRepository
import com.adrianlazaro8.rickmorty.domain.Error
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.PaginatedResult

class GetAllLocations(private val locationsRepository: LocationsRepository) :
    UseCase<PaginatedResult<List<Location>>?> {

    override suspend fun invoke(): Either<Error, PaginatedResult<List<Location>>?> =
        locationsRepository.getAllLocations()
}