package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Location

fun List<CharacterDto>.toDomainCharacterList() = map { it.toDomainCharacter() }

fun CharacterDto.toDomainCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        gender = gender,
        origin = origin,
        location = location,
        image = image,
        episode = episode,
        url = url
    )
}

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