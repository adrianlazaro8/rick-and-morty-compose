package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.EpisodeDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.data.dto.OriginDto
import com.adrianlazaro8.rickmorty.domain.Character
import com.adrianlazaro8.rickmorty.domain.Episode
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.Origin

fun List<CharacterDto>.toDomainCharacterList() = map { it.toDomainCharacter() }

fun CharacterDto.toDomainCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        gender = gender,
        origin = origin.toDomainOrigin(),
        location = location.toDomainLocation(),
        image = image,
        episode = episode,
        url = url
    )
}

fun OriginDto.toDomainOrigin(): Origin {
    return Origin(
        name = name,
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

fun EpisodeDto.toDomainEpisode() =
    Episode(
        id = this.id,
        name = this.name,
        airDate = this.airDate,
        episode = this.episode,
        characters = this.characters,
        url = this.url,
        created = this.created
    )