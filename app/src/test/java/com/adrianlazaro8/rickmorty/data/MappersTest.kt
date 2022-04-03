package com.adrianlazaro8.rickmorty.data

import com.adrianlazaro8.rickmorty.data.dto.CharacterDto
import com.adrianlazaro8.rickmorty.data.dto.EpisodeDto
import com.adrianlazaro8.rickmorty.data.dto.LocationDto
import com.adrianlazaro8.rickmorty.domain.CharacterStatus
import com.adrianlazaro8.rickmorty.domain.Location
import com.adrianlazaro8.rickmorty.domain.Origin
import org.junit.Assert.*

import org.junit.Test

class MappersTest {

    @Test
    fun toDomainCharacter() {

    }

    @Test
    fun toDomainLocation() {
    }

    @Test
    fun toDomainEpisode() {
    }
}

val characterDto = CharacterDto(
    1,
    "name",
    CharacterStatus.unknown,
    "",
    "",
    "",
    Origin("", ""),
    Location(1, "", "", "", listOf(), ""),
    "",
    listOf(),
    "",
    ""
)

val locationDto = LocationDto(
    1,
    "",
    "",
    "",
    listOf(),
    ""
)

val episodeDto = EpisodeDto(
    1,
    "",
    "",
    "",
    listOf(),
    "",
    ""
)