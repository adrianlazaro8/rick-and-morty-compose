package com.adrianlazaro8.rickmorty.data.mappers

import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.domain.Location

fun List<LocationDto>.toDomainLocationList() = map { it.toDomainLocation() }

fun LocationDto.toDomainLocation(): Location =
    Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url
    )